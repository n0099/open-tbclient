package com.bytedance.pangle.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Field> a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Method> f52943b;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Constructor> f52944c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, Class> f52945d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(655548612, "Lcom/bytedance/pangle/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(655548612, "Lcom/bytedance/pangle/a/a/a;");
                return;
            }
        }
        a = new HashMap();
        f52943b = new HashMap();
        f52944c = new HashMap();
        f52945d = new HashMap();
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e2) {
            ZeusLogger.e(ZeusLogger.TAG_INIT, "HackHelperinit failed", e2);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            String b2 = b(cls, str, clsArr);
            synchronized (f52943b) {
                method = f52943b.get(b2);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            try {
                Method a2 = b.a(cls, str, clsArr);
                if (a2 != null) {
                    synchronized (f52943b) {
                        f52943b.put(b2, a2);
                    }
                }
                return a2;
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static String b(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, clsArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append("#");
            sb.append(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class<?> cls2 : clsArr) {
                    sb.append(cls2.getName());
                    sb.append("#");
                }
            } else {
                sb.append(Void.class.getName());
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Constructor constructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            String b2 = b(cls, "clinit", clsArr);
            synchronized (f52944c) {
                constructor = f52944c.get(b2);
            }
            if (constructor != null) {
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
                return constructor;
            }
            try {
                Constructor a2 = b.a(cls, clsArr);
                if (a2 != null) {
                    synchronized (f52944c) {
                        f52944c.put(b2, a2);
                    }
                }
                return a2;
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
                return null;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static Field a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Field field;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
            String str2 = cls.getName() + "#" + str;
            synchronized (a) {
                field = a.get(str2);
            }
            if (field != null) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            }
            try {
                Field a2 = b.a(cls, str);
                if (a2 != null) {
                    synchronized (a) {
                        a.put(str2, a2);
                    }
                }
                return a2;
            } catch (Throwable th) {
                ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                return null;
            }
        }
        return (Field) invokeLL.objValue;
    }
}
