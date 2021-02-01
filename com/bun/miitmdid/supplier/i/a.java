package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f5762a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f5763b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        c = null;
        d = null;
        e = null;
        try {
            f5763b = Class.forName("com.android.id.impl.IdProviderImpl");
            f5762a = f5763b.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            c = f5763b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            d = f5763b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            e = f5763b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, c);
    }

    private static String a(Context context, Method method) {
        if (f5762a != null && method != null) {
            try {
                Object invoke = method.invoke(f5762a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e2) {
                com.bun.miitmdid.utils.a.a("IdentifierManager", "invoke exception!", e2);
            }
        }
        return null;
    }

    public static boolean a() {
        return (f5763b == null || f5762a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, d);
    }

    public static String c(Context context) {
        return a(context, e);
    }
}
