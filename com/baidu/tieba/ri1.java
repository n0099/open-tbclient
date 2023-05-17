package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ri1 {
    public static /* synthetic */ Interceptable $ic;
    public static pi1 a;
    public static qi1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948122479, "Lcom/baidu/tieba/ri1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948122479, "Lcom/baidu/tieba/ri1;");
        }
    }

    public static pi1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (vm0.class) {
                    if (a == null) {
                        a = (pi1) ServiceManager.getService(pi1.a);
                    }
                    if (a == null) {
                        a = pi1.b;
                    }
                }
            }
            return a;
        }
        return (pi1) invokeV.objValue;
    }

    public static qi1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (vm0.class) {
                    if (b == null) {
                        b = (qi1) ServiceManager.getService(qi1.a);
                    }
                    if (b == null) {
                        b = qi1.b;
                    }
                }
            }
            return b;
        }
        return (qi1) invokeV.objValue;
    }
}
