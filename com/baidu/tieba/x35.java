package com.baidu.tieba;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes9.dex */
public @interface x35 {
    boolean isAsync() default false;

    String value() default "";
}
