package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f27644a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f27645b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f27646c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f27647d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f27648e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f27645b = cls;
            f27644a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            f27646c = f27645b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            f27647d = f27645b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            f27648e = f27645b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, f27646c);
    }

    public static String a(Context context, Method method) {
        Object obj = f27644a;
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
        return (f27645b == null || f27644a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f27647d);
    }

    public static String c(Context context) {
        return a(context, f27648e);
    }
}
