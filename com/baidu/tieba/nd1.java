package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nd1 {
    public static /* synthetic */ Interceptable $ic;
    public static ld1 a;
    public static md1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947998510, "Lcom/baidu/tieba/nd1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947998510, "Lcom/baidu/tieba/nd1;");
        }
    }

    public static ld1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qm0.class) {
                    if (a == null) {
                        a = (ld1) ServiceManager.getService(ld1.a);
                    }
                    if (a == null) {
                        a = ld1.b;
                    }
                }
            }
            return a;
        }
        return (ld1) invokeV.objValue;
    }

    public static md1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qm0.class) {
                    if (b == null) {
                        b = (md1) ServiceManager.getService(md1.a);
                    }
                    if (b == null) {
                        b = md1.b;
                    }
                }
            }
            return b;
        }
        return (md1) invokeV.objValue;
    }
}
