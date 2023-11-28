package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class la4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public static Method c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static Method g;
    public static Method h;
    public static Method i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947936138, "Lcom/baidu/tieba/la4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947936138, "Lcom/baidu/tieba/la4;");
                return;
            }
        }
        boolean f2 = ja4.f();
        a = f2;
        if (f2) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                d = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                e = declaredMethod3;
                declaredMethod3.setAccessible(true);
                Method declaredMethod4 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                f = declaredMethod4;
                declaredMethod4.setAccessible(true);
                Method declaredMethod5 = Class.class.getDeclaredMethod("getField", String.class);
                g = declaredMethod5;
                declaredMethod5.setAccessible(true);
                Method declaredMethod6 = Class.class.getDeclaredMethod("newInstance", new Class[0]);
                h = declaredMethod6;
                declaredMethod6.setAccessible(true);
                Method declaredMethod7 = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                i = declaredMethod7;
                declaredMethod7.setAccessible(true);
                b = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static Class<?> a(String str) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return b(str, false);
        }
        return (Class) invokeL.objValue;
    }

    public static boolean l(Member member) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, member)) == null) {
            if (member == null) {
                return false;
            }
            return Modifier.isStatic(member.getModifiers());
        }
        return invokeL.booleanValue;
    }

    public static <T> T m(Class<T> cls) throws InvocationTargetException, IllegalAccessException, InstantiationException, ClassCastException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) {
            if (cls == null) {
                return null;
            }
            if (a && b) {
                return (T) h.invoke(cls, new Object[0]);
            }
            return cls.newInstance();
        }
        return (T) invokeL.objValue;
    }

    public static Class<?> b(String str, boolean z) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                ja4.d(ja4.b(str));
            }
            if (a && b) {
                return (Class) c.invoke(null, str);
            }
            return Class.forName(str);
        }
        return (Class) invokeLZ.objValue;
    }

    public static <T> Constructor<T> c(Class<T> cls, Class<?>... clsArr) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassCastException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, clsArr)) == null) {
            if (cls == null) {
                return null;
            }
            if (a && b) {
                return (Constructor) i.invoke(cls, clsArr);
            }
            return cls.getDeclaredConstructor(clsArr);
        }
        return (Constructor) invokeLL.objValue;
    }

    public static Field d(Class<?> cls, String str) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str)) == null) {
            if (cls != null && !TextUtils.isEmpty(str)) {
                if (a && b) {
                    return (Field) f.invoke(cls, str);
                }
                return cls.getDeclaredField(str);
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static Field f(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, cls, str)) == null) {
            Field field = null;
            if (cls != null && !TextUtils.isEmpty(str)) {
                boolean z = false;
                for (Class<?> cls2 = cls; cls2 != null && cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                    try {
                        field = d(cls, str);
                    } catch (Exception unused) {
                    }
                    if (field == null && !z) {
                        z = true;
                        try {
                            field = g(cls, str);
                        } catch (Exception unused2) {
                        }
                    }
                    if (field != null) {
                        return field;
                    }
                }
            }
            return field;
        }
        return (Field) invokeLL.objValue;
    }

    public static Field g(Class<?> cls, String str) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, cls, str)) == null) {
            if (cls != null && !TextUtils.isEmpty(str)) {
                if (a && b) {
                    return (Field) g.invoke(cls, str);
                }
                return cls.getField(str);
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static Method e(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, str, clsArr)) == null) {
            if (cls != null && !TextUtils.isEmpty(str)) {
                if (a && b) {
                    return (Method) d.invoke(cls, str, clsArr);
                }
                return cls.getDeclaredMethod(str, clsArr);
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method i(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, clsArr)) == null) {
            Method method = null;
            if (cls != null && !TextUtils.isEmpty(str)) {
                boolean z = false;
                for (Class<?> cls2 = cls; cls2 != null && cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                    try {
                        method = e(cls, str, clsArr);
                    } catch (Exception unused) {
                    }
                    if (method == null && !z) {
                        z = true;
                        try {
                            method = j(cls, str, clsArr);
                        } catch (Exception unused2) {
                        }
                    }
                    if (method != null) {
                        return method;
                    }
                }
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method j(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, cls, str, clsArr)) == null) {
            if (cls != null && !TextUtils.isEmpty(str)) {
                if (a && b) {
                    return (Method) e.invoke(cls, str, clsArr);
                }
                return cls.getMethod(str, clsArr);
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object k(Class<?> cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Class[] clsArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, cls, str, objArr)) == null) {
            if (objArr != null) {
                clsArr = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    clsArr[i2] = objArr[i2].getClass();
                }
            } else {
                clsArr = null;
            }
            Method i3 = i(cls, str, clsArr);
            if (i3 == null) {
                return null;
            }
            try {
                i3.setAccessible(true);
                if (!l(i3)) {
                    return null;
                }
                return i3.invoke(null, objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object h(Object obj, String str) {
        InterceptResult invokeLL;
        Field f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
            if (obj == null || TextUtils.isEmpty(str) || (f2 = f(obj.getClass(), str)) == null) {
                return null;
            }
            try {
                f2.setAccessible(true);
                return f2.get(obj);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLL.objValue;
    }
}
