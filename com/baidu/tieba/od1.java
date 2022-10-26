package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class od1 {
    public static /* synthetic */ Interceptable $ic;
    public static md1 a;
    public static nd1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948028301, "Lcom/baidu/tieba/od1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948028301, "Lcom/baidu/tieba/od1;");
        }
    }

    public static md1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (rm0.class) {
                    if (a == null) {
                        a = (md1) ServiceManager.getService(md1.a);
                    }
                    if (a == null) {
                        a = md1.b;
                    }
                }
            }
            return a;
        }
        return (md1) invokeV.objValue;
    }

    public static nd1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (rm0.class) {
                    if (b == null) {
                        b = (nd1) ServiceManager.getService(nd1.a);
                    }
                    if (b == null) {
                        b = nd1.b;
                    }
                }
            }
            return b;
        }
        return (nd1) invokeV.objValue;
    }
}
