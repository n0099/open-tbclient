package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ke1 {
    public static /* synthetic */ Interceptable $ic;
    public static ie1 a;
    public static je1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947910098, "Lcom/baidu/tieba/ke1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947910098, "Lcom/baidu/tieba/ke1;");
        }
    }

    public static ie1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ij0.class) {
                    if (a == null) {
                        a = (ie1) ServiceManager.getService(ie1.a);
                    }
                    if (a == null) {
                        a = ie1.b;
                    }
                }
            }
            return a;
        }
        return (ie1) invokeV.objValue;
    }

    public static je1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ij0.class) {
                    if (b == null) {
                        b = (je1) ServiceManager.getService(je1.a);
                    }
                    if (b == null) {
                        b = je1.b;
                    }
                }
            }
            return b;
        }
        return (je1) invokeV.objValue;
    }
}
