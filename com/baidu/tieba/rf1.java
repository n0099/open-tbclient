package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public class rf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class<?> a(String str) throws ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return Class.forName(str);
        }
        return (Class) invokeL.objValue;
    }

    public static Field b(Class<?> cls, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, str)) == null) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    i(declaredField, true);
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = null;
            for (Class<?> cls3 : cls.getInterfaces()) {
                try {
                    Field field2 = cls3.getField(str);
                    if (field == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    uf1.a(z, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    field = field2;
                } catch (NoSuchFieldException unused2) {
                }
            }
            return field;
        }
        return (Field) invokeLL.objValue;
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, cls, str, clsArr)) == null) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                    i(declaredMethod, true);
                    return declaredMethod;
                } catch (NoSuchMethodException unused) {
                }
            }
            Method method = null;
            for (Class<?> cls3 : cls.getInterfaces()) {
                try {
                    Method method2 = cls3.getMethod(str, clsArr);
                    if (method == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    uf1.a(z, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                    method = method2;
                } catch (NoSuchMethodException unused2) {
                }
            }
            return method;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object d(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, obj, str, clsArr, objArr)) == null) {
            Method c = c(obj.getClass(), str, clsArr);
            c.setAccessible(true);
            return c.invoke(obj, objArr);
        }
        return invokeLLLL.objValue;
    }

    public static void j(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, cls, obj, str, obj2) == null) {
            l(b(cls, str), obj, obj2);
        }
    }

    public static Object e(Class<?> cls, Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, obj, str)) == null) {
            return g(b(cls, str), obj);
        }
        return invokeLLL.objValue;
    }

    public static void k(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, obj, str, obj2) == null) {
            j(obj.getClass(), obj, str, obj2);
        }
    }

    public static void l(Field field, Object obj, Object obj2) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, field, obj, obj2) == null) {
            field.set(obj, obj2);
        }
    }

    public static Object f(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, str)) == null) {
            return e(obj.getClass(), obj, str);
        }
        return invokeLL.objValue;
    }

    public static Object g(Field field, Object obj) throws IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, field, obj)) == null) {
            return field.get(obj);
        }
        return invokeLL.objValue;
    }

    public static void i(AccessibleObject accessibleObject, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65544, null, accessibleObject, z) == null) && accessibleObject.isAccessible() != z) {
            accessibleObject.setAccessible(z);
        }
    }

    public static void h(Field field) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, field) == null) {
            if (field != null) {
                z = true;
            } else {
                z = false;
            }
            uf1.a(z, "The field must not be null", new Object[0]);
            try {
                if (Modifier.isFinal(field.getModifiers())) {
                    Field declaredField = Field.class.getDeclaredField("modifiers");
                    boolean z2 = !declaredField.isAccessible();
                    if (z2) {
                        declaredField.setAccessible(true);
                    }
                    declaredField.setInt(field, field.getModifiers() & (-17));
                    if (z2) {
                        declaredField.setAccessible(false);
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }
}
