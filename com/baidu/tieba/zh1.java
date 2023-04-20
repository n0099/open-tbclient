package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zh1 {
    public static /* synthetic */ Interceptable $ic;
    public static xh1 a;
    public static yh1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948359846, "Lcom/baidu/tieba/zh1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948359846, "Lcom/baidu/tieba/zh1;");
        }
    }

    public static xh1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (dm0.class) {
                    if (a == null) {
                        a = (xh1) ServiceManager.getService(xh1.a);
                    }
                    if (a == null) {
                        a = xh1.b;
                    }
                }
            }
            return a;
        }
        return (xh1) invokeV.objValue;
    }

    public static yh1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (dm0.class) {
                    if (b == null) {
                        b = (yh1) ServiceManager.getService(yh1.a);
                    }
                    if (b == null) {
                        b = yh1.b;
                    }
                }
            }
            return b;
        }
        return (yh1) invokeV.objValue;
    }
}
