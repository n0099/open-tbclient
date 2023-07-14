package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xj1 {
    public static /* synthetic */ Interceptable $ic;
    public static vj1 a;
    public static wj1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948302186, "Lcom/baidu/tieba/xj1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948302186, "Lcom/baidu/tieba/xj1;");
        }
    }

    public static vj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (so0.class) {
                    if (a == null) {
                        a = (vj1) ServiceManager.getService(vj1.a);
                    }
                    if (a == null) {
                        a = vj1.b;
                    }
                }
            }
            return a;
        }
        return (vj1) invokeV.objValue;
    }

    public static wj1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (so0.class) {
                    if (b == null) {
                        b = (wj1) ServiceManager.getService(wj1.a);
                    }
                    if (b == null) {
                        b = wj1.b;
                    }
                }
            }
            return b;
        }
        return (wj1) invokeV.objValue;
    }
}
