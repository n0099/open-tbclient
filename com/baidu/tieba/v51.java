package com.baidu.tieba;

import android.content.Context;
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
public class v51 {
    public static /* synthetic */ Interceptable $ic;
    public static y51 a;
    public static b61 b;
    public static c61 c;
    public static f51 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948191671, "Lcom/baidu/tieba/v51;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948191671, "Lcom/baidu/tieba/v51;");
        }
    }

    public v51() {
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

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return zi0.b();
        }
        return (Context) invokeV.objValue;
    }

    public static z51 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return z51.a;
        }
        return (z51) invokeV.objValue;
    }

    public static w51 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return w51.a;
        }
        return (w51) invokeV.objValue;
    }

    public static x51 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return x51.a;
        }
        return (x51) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (qm0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (qm0.b().a().a("nad_web_view_type_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static y51 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (v51.class) {
                    if (a == null) {
                        a = (y51) ServiceManager.getService(y51.a);
                    }
                    if (a == null) {
                        a = y51.b;
                    }
                }
            }
            return a;
        }
        return (y51) invokeV.objValue;
    }

    public static f51 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (v51.class) {
                    if (d == null) {
                        d = (f51) ServiceManager.getService(f51.a);
                    }
                    if (d == null) {
                        d = f51.b;
                    }
                }
            }
            return d;
        }
        return (f51) invokeV.objValue;
    }

    public static b61 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (v51.class) {
                    if (b == null) {
                        b = (b61) ServiceManager.getService(b61.a);
                    }
                    if (b == null) {
                        b = b61.b;
                    }
                }
            }
            return b;
        }
        return (b61) invokeV.objValue;
    }

    public static c61 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (c == null) {
                synchronized (v51.class) {
                    if (c == null) {
                        c = (c61) ServiceManager.getService(c61.a);
                    }
                    if (c == null) {
                        c = c61.b;
                    }
                }
            }
            return c;
        }
        return (c61) invokeV.objValue;
    }
}
