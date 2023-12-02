package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ne1 {
    public static /* synthetic */ Interceptable $ic;
    public static le1 a;
    public static me1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947999471, "Lcom/baidu/tieba/ne1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947999471, "Lcom/baidu/tieba/ne1;");
        }
    }

    public static le1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ij0.class) {
                    if (a == null) {
                        a = (le1) ServiceManager.getService(le1.a);
                    }
                    if (a == null) {
                        a = le1.b;
                    }
                }
            }
            return a;
        }
        return (le1) invokeV.objValue;
    }

    public static me1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ij0.class) {
                    if (b == null) {
                        b = (me1) ServiceManager.getService(me1.a);
                    }
                    if (b == null) {
                        b = me1.b;
                    }
                }
            }
            return b;
        }
        return (me1) invokeV.objValue;
    }
}
