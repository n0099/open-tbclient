package com.baidu.tieba;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wi1 {
    public static /* synthetic */ Interceptable $ic;
    public static ui1 a;
    public static vi1 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948271434, "Lcom/baidu/tieba/wi1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948271434, "Lcom/baidu/tieba/wi1;");
        }
    }

    public static ui1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (hn0.class) {
                    if (a == null) {
                        a = (ui1) ServiceManager.getService(ui1.a);
                    }
                    if (a == null) {
                        a = ui1.b;
                    }
                }
            }
            return a;
        }
        return (ui1) invokeV.objValue;
    }

    public static vi1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (hn0.class) {
                    if (b == null) {
                        b = (vi1) ServiceManager.getService(vi1.a);
                    }
                    if (b == null) {
                        b = vi1.b;
                    }
                }
            }
            return b;
        }
        return (vi1) invokeV.objValue;
    }
}
