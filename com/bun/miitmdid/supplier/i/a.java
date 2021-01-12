package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Object f5760a;

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f5761b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        c = null;
        d = null;
        e = null;
        try {
            f5761b = Class.forName("com.android.id.impl.IdProviderImpl");
            f5760a = f5761b.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            c = f5761b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            d = f5761b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            e = f5761b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, c);
    }

    private static String a(Context context, Method method) {
        if (f5760a != null && method != null) {
            try {
                Object invoke = method.invoke(f5760a, context);
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
        return (f5761b == null || f5760a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, d);
    }

    public static String c(Context context) {
        return a(context, e);
    }
}
