package com.bytedance.sdk.openadsdk.d.b.b;

import com.bytedance.sdk.openadsdk.d.b.e;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f7225a;

    public abstract void a(AccessibleObject accessibleObject);

    static {
        f7225a = e.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f7225a;
    }
}
