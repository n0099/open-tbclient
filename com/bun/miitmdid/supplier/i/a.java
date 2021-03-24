package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f27136a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f27137b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f27138c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f27139d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f27140e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f27137b = cls;
            f27136a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            f27138c = f27137b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            f27139d = f27137b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            f27140e = f27137b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, f27138c);
    }

    public static String a(Context context, Method method) {
        Object obj = f27136a;
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
        return (f27137b == null || f27136a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f27139d);
    }

    public static String c(Context context) {
        return a(context, f27140e);
    }
}
