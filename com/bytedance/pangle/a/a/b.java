package com.bytedance.pangle.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes12.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Field a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, str)) == null) {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null && !declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        }
        return (Field) invokeLL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null && !declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            return declaredMethod;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cls, clsArr)) == null) {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            if (declaredConstructor != null && !declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        }
        return (Constructor) invokeLL.objValue;
    }
}
