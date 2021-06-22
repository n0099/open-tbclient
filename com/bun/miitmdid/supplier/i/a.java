package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f27003a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f27004b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f27005c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f27006d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f27007e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f27004b = cls;
            f27003a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            f27005c = f27004b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            f27006d = f27004b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            f27007e = f27004b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, f27005c);
    }

    public static String a(Context context, Method method) {
        Object obj = f27003a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }

    public static boolean a() {
        return (f27004b == null || f27003a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f27006d);
    }

    public static String c(Context context) {
        return a(context, f27007e);
    }
}
