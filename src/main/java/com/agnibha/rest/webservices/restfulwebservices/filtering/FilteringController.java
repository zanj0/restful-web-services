package com.agnibha.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    // field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean bean = new SomeBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        mapping.setFilters(filters);
        return mapping;
    }
    //field2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){
        List<SomeBean> beans = Arrays.asList(new SomeBean("value11", "value21", "value31"), new SomeBean("value12", "value22", "value32"));
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mapping = new MappingJacksonValue(beans);
        mapping.setFilters(filters);
        return mapping;

    }
}
