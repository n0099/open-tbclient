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
public class np0 {
    public static /* synthetic */ Interceptable $ic;
    public static kp0 a;
    public static mp0 b;
    public static jp0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948010011, "Lcom/baidu/tieba/np0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948010011, "Lcom/baidu/tieba/np0;");
        }
    }

    public np0() {
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

    public static jp0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (np0.class) {
                    if (c == null) {
                        c = (jp0) ServiceManager.getService(jp0.a);
                    }
                    if (c == null) {
                        c = jp0.b;
                    }
                }
            }
            return c;
        }
        return (jp0) invokeV.objValue;
    }

    public static kp0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (np0.class) {
                    if (a == null) {
                        a = (kp0) ServiceManager.getService(kp0.a);
                    }
                    if (a == null) {
                        a = kp0.b;
                    }
                }
            }
            return a;
        }
        return (kp0) invokeV.objValue;
    }

    public static mp0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (np0.class) {
                    if (b == null) {
                        b = (mp0) ServiceManager.getService(mp0.a);
                    }
                    if (b == null) {
                        b = mp0.b;
                    }
                }
            }
            return b;
        }
        return (mp0) invokeV.objValue;
    }
}
