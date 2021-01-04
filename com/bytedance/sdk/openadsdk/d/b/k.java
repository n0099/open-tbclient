package com.bytedance.sdk.openadsdk.d.b;

import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public final class k {
    public static boolean a(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }
}
