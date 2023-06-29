package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class tb1 {
    public static /* synthetic */ Interceptable $ic;
    public static wb1 a;
    public static c81 b;
    public static zb1 c;
    public static e81 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948175334, "Lcom/baidu/tieba/tb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948175334, "Lcom/baidu/tieba/tb1;");
        }
    }

    public tb1() {
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
            return ok0.b();
        }
        return (Context) invokeV.objValue;
    }

    public static xb1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return xb1.a;
        }
        return (xb1) invokeV.objValue;
    }

    public static ub1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return ub1.a;
        }
        return (ub1) invokeV.objValue;
    }

    public static vb1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return vb1.a;
        }
        return (vb1) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (io0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
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
            if (io0.b().a().a("nad_web_view_type_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static wb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (tb1.class) {
                    if (a == null) {
                        a = (wb1) ServiceManager.getService(wb1.a);
                    }
                    if (a == null) {
                        a = wb1.b;
                    }
                }
            }
            return a;
        }
        return (wb1) invokeV.objValue;
    }

    public static e81 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (tb1.class) {
                    if (d == null) {
                        d = (e81) ServiceManager.getService(e81.a);
                    }
                    if (d == null) {
                        d = e81.b;
                    }
                }
            }
            return d;
        }
        return (e81) invokeV.objValue;
    }

    public static c81 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (tb1.class) {
                    if (b == null) {
                        b = (c81) ServiceManager.getService(new ServiceReference("nad.core", "navBarTool"));
                    }
                    if (b == null) {
                        b = c81.b;
                    }
                }
            }
            return b;
        }
        return (c81) invokeV.objValue;
    }

    public static zb1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (c == null) {
                synchronized (tb1.class) {
                    if (c == null) {
                        c = (zb1) ServiceManager.getService(zb1.a);
                    }
                    if (c == null) {
                        c = zb1.b;
                    }
                }
            }
            return c;
        }
        return (zb1) invokeV.objValue;
    }
}
