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
/* loaded from: classes6.dex */
public class jp0 {
    public static /* synthetic */ Interceptable $ic;
    public static gp0 a;
    public static ip0 b;
    public static fp0 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947890847, "Lcom/baidu/tieba/jp0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947890847, "Lcom/baidu/tieba/jp0;");
        }
    }

    public jp0() {
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

    public static fp0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (jp0.class) {
                    if (c == null) {
                        c = (fp0) ServiceManager.getService(fp0.a);
                    }
                    if (c == null) {
                        c = fp0.b;
                    }
                }
            }
            return c;
        }
        return (fp0) invokeV.objValue;
    }

    public static gp0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (jp0.class) {
                    if (a == null) {
                        a = (gp0) ServiceManager.getService(gp0.a);
                    }
                    if (a == null) {
                        a = gp0.b;
                    }
                }
            }
            return a;
        }
        return (gp0) invokeV.objValue;
    }

    public static ip0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (jp0.class) {
                    if (b == null) {
                        b = (ip0) ServiceManager.getService(ip0.a);
                    }
                    if (b == null) {
                        b = ip0.b;
                    }
                }
            }
            return b;
        }
        return (ip0) invokeV.objValue;
    }
}
