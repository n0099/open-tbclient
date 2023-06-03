package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes6.dex */
public final class l8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class a(String str) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw new ReflectionException("Class not found: " + str, e);
            }
        }
        return (Class) invokeL.objValue;
    }

    public static n8[] d(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) {
            Field[] declaredFields = cls.getDeclaredFields();
            n8[] n8VarArr = new n8[declaredFields.length];
            int length = declaredFields.length;
            for (int i = 0; i < length; i++) {
                n8VarArr[i] = new n8(declaredFields[i]);
            }
            return n8VarArr;
        }
        return (n8[]) invokeL.objValue;
    }

    public static String e(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) {
            return cls.getSimpleName();
        }
        return (String) invokeL.objValue;
    }

    public static boolean g(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, cls)) == null) {
            return cls.isMemberClass();
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            return Modifier.isStatic(cls.getModifiers());
        }
        return invokeL.booleanValue;
    }

    public static m8 b(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            try {
                return new m8(cls.getConstructor(clsArr));
            } catch (NoSuchMethodException e) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e);
            } catch (SecurityException e2) {
                throw new ReflectionException("Security violation occurred while getting constructor for class: '" + cls.getName() + "'.", e2);
            }
        }
        return (m8) invokeLL.objValue;
    }

    public static m8 c(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, clsArr)) == null) {
            try {
                return new m8(cls.getDeclaredConstructor(clsArr));
            } catch (NoSuchMethodException e) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e);
            } catch (SecurityException e2) {
                throw new ReflectionException("Security violation while getting constructor for class: " + cls.getName(), e2);
            }
        }
        return (m8) invokeLL.objValue;
    }

    public static boolean f(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, cls2)) == null) {
            return cls.isAssignableFrom(cls2);
        }
        return invokeLL.booleanValue;
    }

    public static <T> T i(Class<T> cls) throws ReflectionException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new ReflectionException("Could not instantiate instance of class: " + cls.getName(), e);
            } catch (InstantiationException e2) {
                throw new ReflectionException("Could not instantiate instance of class: " + cls.getName(), e2);
            }
        }
        return (T) invokeL.objValue;
    }
}
