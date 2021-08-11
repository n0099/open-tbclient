package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v() {
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

    public static Method a(String str, String str2, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, clsArr)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                Class<?> a2 = a(str);
                if (a2 != null) {
                    return a2.getMethod(str2, clsArr);
                }
                return null;
            } catch (Throwable th) {
                k.a("TTClassLoader", "get method: " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2, th);
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Class<?> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                try {
                    try {
                        return Class.forName(str, true, a());
                    } catch (ClassNotFoundException unused) {
                        return Class.forName(str);
                    }
                } catch (ClassNotFoundException unused2) {
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return Class.forName(str, true, v.class.getClassLoader());
            }
        }
        return (Class) invokeL.objValue;
    }

    public static ClassLoader a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader == null ? v.class.getClassLoader() : contextClassLoader;
        }
        return (ClassLoader) invokeV.objValue;
    }
}
