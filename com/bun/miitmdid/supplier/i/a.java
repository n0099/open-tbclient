package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f26830a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f26831b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f26832c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f26833d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f26834e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f26831b = cls;
            f26830a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            f26832c = f26831b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            f26833d = f26831b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            f26834e = f26831b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, f26832c);
    }

    public static String a(Context context, Method method) {
        Object obj = f26830a;
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
        return (f26831b == null || f26830a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f26833d);
    }

    public static String c(Context context) {
        return a(context, f26834e);
    }
}
