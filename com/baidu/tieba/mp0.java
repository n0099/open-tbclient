package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mp0 {
    public static /* synthetic */ Interceptable $ic;
    public static jp0 a;
    public static lp0 b;
    public static ip0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947980220, "Lcom/baidu/tieba/mp0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947980220, "Lcom/baidu/tieba/mp0;");
        }
    }

    public mp0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ip0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (mp0.class) {
                    if (c == null) {
                        c = (ip0) ServiceManager.getService(ip0.a);
                    }
                    if (c == null) {
                        c = ip0.b;
                    }
                }
            }
            return c;
        }
        return (ip0) invokeV.objValue;
    }

    public static jp0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (mp0.class) {
                    if (a == null) {
                        a = (jp0) ServiceManager.getService(jp0.a);
                    }
                    if (a == null) {
                        a = jp0.b;
                    }
                }
            }
            return a;
        }
        return (jp0) invokeV.objValue;
    }

    public static lp0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (mp0.class) {
                    if (b == null) {
                        b = (lp0) ServiceManager.getService(lp0.a);
                    }
                    if (b == null) {
                        b = lp0.b;
                    }
                }
            }
            return b;
        }
        return (lp0) invokeV.objValue;
    }
}
