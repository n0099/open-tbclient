package com.bytedance.sdk.openadsdk.d.a;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface c {
    String a();

    String[] b() default {};
}
