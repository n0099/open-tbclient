package com.bun.miitmdid.supplier.i;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Object f26818a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f26819b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f26820c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f26821d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f26822e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f26819b = cls;
            f26818a = cls.newInstance();
        } catch (Exception e2) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            f26820c = f26819b.getMethod("getOAID", Context.class);
        } catch (Exception e3) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            f26821d = f26819b.getMethod("getVAID", Context.class);
        } catch (Exception e4) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            f26822e = f26819b.getMethod("getAAID", Context.class);
        } catch (Exception e5) {
            com.bun.miitmdid.utils.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    public static String a(Context context) {
        return a(context, f26820c);
    }

    public static String a(Context context, Method method) {
        Object obj = f26818a;
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
        return (f26819b == null || f26818a == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f26821d);
    }

    public static String c(Context context) {
        return a(context, f26822e);
    }
}
