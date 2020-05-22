package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {
    private static Object a;
    private static Class<?> b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        c = null;
        d = null;
        e = null;
        try {
            b = Class.forName("com.android.id.impl.IdProviderImpl");
            a = b.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            d = b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            e = b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, c);
    }

    private static String a(Context context, Method method) {
        if (a != null && method != null) {
            try {
                Object invoke = method.invoke(a, context);
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
        return (b == null || a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, d);
    }

    public static String c(Context context) {
        return a(context, e);
    }
}
