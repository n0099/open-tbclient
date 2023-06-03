package com.bytedance.pangle.a.b;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public final class a {
    public static Method a;
    public static Method b;
    public static Method c;
    public static Method d;

    static {
        try {
            a = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            c = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            d = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = c;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getConstructor %s<init>%s failed !!!", cls.getName(), 1), th);
            }
            if (constructor == null) {
                return constructor;
            }
            return com.bytedance.pangle.a.a.a.a(cls, clsArr);
        }
        constructor = null;
        if (constructor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Field a(Class<?> cls, String str) {
        Throwable th;
        Field field;
        Method method = a;
        Field field2 = null;
        if (method != null) {
            try {
                field = (Field) method.invoke(cls, str);
                if (field != null) {
                    try {
                        field.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                        field2 = field;
                        if (field2 == null) {
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                field = null;
            }
            field2 = field;
        }
        if (field2 == null) {
            return field2;
        }
        return com.bytedance.pangle.a.a.a.a(cls, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Throwable th;
        Method method;
        Method method2 = b;
        Method method3 = null;
        if (method2 != null) {
            try {
                method = (Method) method2.invoke(cls, str, clsArr);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                        method3 = method;
                        if (method3 == null) {
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                method = null;
            }
            method3 = method;
        }
        if (method3 == null) {
            return method3;
        }
        return com.bytedance.pangle.a.a.a.a(cls, str, clsArr);
    }
}
