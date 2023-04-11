package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yh1 {
    public static /* synthetic */ Interceptable $ic;
    public static wh1 a;
    public static xh1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948330055, "Lcom/baidu/tieba/yh1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948330055, "Lcom/baidu/tieba/yh1;");
        }
    }

    public static wh1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (cm0.class) {
                    if (a == null) {
                        a = (wh1) ServiceManager.getService(wh1.a);
                    }
                    if (a == null) {
                        a = wh1.b;
                    }
                }
            }
            return a;
        }
        return (wh1) invokeV.objValue;
    }

    public static xh1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (cm0.class) {
                    if (b == null) {
                        b = (xh1) ServiceManager.getService(xh1.a);
                    }
                    if (b == null) {
                        b = xh1.b;
                    }
                }
            }
            return b;
        }
        return (xh1) invokeV.objValue;
    }
}
