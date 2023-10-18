package com.baidu.tieba;

import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class m3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static n3 a(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cls, clsArr)) == null) {
            try {
                return new n3(cls.getConstructor(clsArr));
            } catch (NoSuchMethodException e) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e);
            } catch (SecurityException e2) {
                throw new ReflectionException("Security violation occurred while getting constructor for class: '" + cls.getName() + "'.", e2);
            }
        }
        return (n3) invokeLL.objValue;
    }

    public static n3 b(Class cls, Class... clsArr) throws ReflectionException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            try {
                return new n3(cls.getDeclaredConstructor(clsArr));
            } catch (NoSuchMethodException e) {
                throw new ReflectionException("Constructor not found for class: " + cls.getName(), e);
            } catch (SecurityException e2) {
                throw new ReflectionException("Security violation while getting constructor for class: " + cls.getName(), e2);
            }
        }
        return (n3) invokeLL.objValue;
    }
}
