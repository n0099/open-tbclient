package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f26921a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f26922b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f26923c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f26924d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f26925e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f26922b = cls;
            f26921a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            f26923c = f26922b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            f26924d = f26922b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            f26925e = f26922b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, f26923c);
    }

    public static String a(Context context, Method method) {
        Object obj = f26921a;
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
        return (f26922b == null || f26921a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f26924d);
    }

    public static String c(Context context) {
        return a(context, f26925e);
    }
}
