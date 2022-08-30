package com.bytedance.pangle.a.b;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static Method a;
    public static Method b;
    public static Method c;
    public static Method d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(655578403, "Lcom/bytedance/pangle/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(655578403, "Lcom/bytedance/pangle/a/b/a;");
                return;
            }
        }
        try {
            a = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            c = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            d = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Field a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Throwable th;
        Field field;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
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
            return field2 == null ? field2 : com.bytedance.pangle.a.a.a.a(cls, str);
        }
        return (Field) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Throwable th;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
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
            return method3 == null ? method3 : com.bytedance.pangle.a.a.a.a(cls, str, clsArr);
        }
        return (Method) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Constructor constructor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) != null) {
            return (Constructor) invokeLL.objValue;
        }
        Method method = c;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getConstructor %s<init>%s failed !!!", cls.getName(), 1), th);
            }
            return constructor == null ? constructor : com.bytedance.pangle.a.a.a.a(cls, clsArr);
        }
        constructor = null;
        if (constructor == null) {
        }
    }
}
