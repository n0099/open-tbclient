package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sd1 {
    public static /* synthetic */ Interceptable $ic;
    public static qd1 a;
    public static rd1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948147465, "Lcom/baidu/tieba/sd1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948147465, "Lcom/baidu/tieba/sd1;");
        }
    }

    public static qd1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qi0.class) {
                    if (a == null) {
                        a = (qd1) ServiceManager.getService(qd1.a);
                    }
                    if (a == null) {
                        a = qd1.b;
                    }
                }
            }
            return a;
        }
        return (qd1) invokeV.objValue;
    }

    public static rd1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qi0.class) {
                    if (b == null) {
                        b = (rd1) ServiceManager.getService(rd1.a);
                    }
                    if (b == null) {
                        b = rd1.b;
                    }
                }
            }
            return b;
        }
        return (rd1) invokeV.objValue;
    }
}
