package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jj1 {
    public static /* synthetic */ Interceptable $ic;
    public static hj1 a;
    public static ij1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947885112, "Lcom/baidu/tieba/jj1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947885112, "Lcom/baidu/tieba/jj1;");
        }
    }

    public static hj1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (un0.class) {
                    if (a == null) {
                        a = (hj1) ServiceManager.getService(hj1.a);
                    }
                    if (a == null) {
                        a = hj1.b;
                    }
                }
            }
            return a;
        }
        return (hj1) invokeV.objValue;
    }

    public static ij1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (un0.class) {
                    if (b == null) {
                        b = (ij1) ServiceManager.getService(ij1.a);
                    }
                    if (b == null) {
                        b = ij1.b;
                    }
                }
            }
            return b;
        }
        return (ij1) invokeV.objValue;
    }
}
