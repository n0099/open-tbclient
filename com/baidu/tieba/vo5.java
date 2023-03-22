package com.baidu.tieba;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface vo5 {
    boolean deserialize() default true;

    boolean serialize() default true;
}
