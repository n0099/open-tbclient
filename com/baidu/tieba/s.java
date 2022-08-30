package com.baidu.tieba;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static r a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                return new t();
            }
            if (i >= 23) {
                return new v();
            }
            return i >= 14 ? new q() : new u();
        }
        return (r) invokeV.objValue;
    }

    public static Object b(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, cls, clsArr, objArr)) == null) {
            try {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object c(Class cls, Object[] objArr, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, objArr, obj)) == null) {
            Object newInstance = Array.newInstance(cls, objArr.length + 1);
            Array.set(newInstance, 0, obj);
            for (int i = 1; i < objArr.length + 1; i++) {
                Array.set(newInstance, i, objArr[i - 1]);
            }
            return newInstance;
        }
        return invokeLLL.objValue;
    }

    public static Field d(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static void e(Object obj, String str, Object obj2) {
        Field d;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, obj2) == null) || (d = d(obj, str)) == null) {
            return;
        }
        d.setAccessible(true);
        try {
            d.set(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> boolean f(T[] tArr, T t) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, tArr, t)) == null) {
            if (tArr != null) {
                i = 0;
                while (i < tArr.length) {
                    T t2 = tArr[i];
                    if (t2 == t || (t2 != null && t2.equals(t))) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
            return i != -1;
        }
        return invokeLL.booleanValue;
    }

    public static Object g(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, obj, str)) == null) {
            Field d = d(obj, str);
            if (d != null) {
                d.setAccessible(true);
                try {
                    return d.get(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
