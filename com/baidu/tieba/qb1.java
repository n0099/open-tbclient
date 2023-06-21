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
public class qb1 {
    public static /* synthetic */ Interceptable $ic;
    public static tb1 a;
    public static z71 b;
    public static wb1 c;
    public static b81 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948085961, "Lcom/baidu/tieba/qb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948085961, "Lcom/baidu/tieba/qb1;");
        }
    }

    public qb1() {
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
            return lk0.b();
        }
        return (Context) invokeV.objValue;
    }

    public static ub1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return ub1.a;
        }
        return (ub1) invokeV.objValue;
    }

    public static rb1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return rb1.a;
        }
        return (rb1) invokeV.objValue;
    }

    public static sb1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return sb1.a;
        }
        return (sb1) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (fo0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
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
            if (fo0.b().a().a("nad_web_view_type_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static tb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (qb1.class) {
                    if (a == null) {
                        a = (tb1) ServiceManager.getService(tb1.a);
                    }
                    if (a == null) {
                        a = tb1.b;
                    }
                }
            }
            return a;
        }
        return (tb1) invokeV.objValue;
    }

    public static b81 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (d == null) {
                synchronized (qb1.class) {
                    if (d == null) {
                        d = (b81) ServiceManager.getService(b81.a);
                    }
                    if (d == null) {
                        d = b81.b;
                    }
                }
            }
            return d;
        }
        return (b81) invokeV.objValue;
    }

    public static z71 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (qb1.class) {
                    if (b == null) {
                        b = (z71) ServiceManager.getService(new ServiceReference("nad.core", "navBarTool"));
                    }
                    if (b == null) {
                        b = z71.b;
                    }
                }
            }
            return b;
        }
        return (z71) invokeV.objValue;
    }

    public static wb1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (c == null) {
                synchronized (qb1.class) {
                    if (c == null) {
                        c = (wb1) ServiceManager.getService(wb1.a);
                    }
                    if (c == null) {
                        c = wb1.b;
                    }
                }
            }
            return c;
        }
        return (wb1) invokeV.objValue;
    }
}
