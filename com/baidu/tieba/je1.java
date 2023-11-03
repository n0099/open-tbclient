package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class je1 {
    public static /* synthetic */ Interceptable $ic;
    public static he1 a;
    public static ie1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947880307, "Lcom/baidu/tieba/je1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947880307, "Lcom/baidu/tieba/je1;");
        }
    }

    public static he1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (hj0.class) {
                    if (a == null) {
                        a = (he1) ServiceManager.getService(he1.a);
                    }
                    if (a == null) {
                        a = he1.b;
                    }
                }
            }
            return a;
        }
        return (he1) invokeV.objValue;
    }

    public static ie1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (hj0.class) {
                    if (b == null) {
                        b = (ie1) ServiceManager.getService(ie1.a);
                    }
                    if (b == null) {
                        b = ie1.b;
                    }
                }
            }
            return b;
        }
        return (ie1) invokeV.objValue;
    }
}
