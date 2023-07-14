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
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pb1 {
    public static /* synthetic */ Interceptable $ic;
    public static d91 a;
    public static sb1 b;
    public static f91 c;
    public static rb1 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948056170, "Lcom/baidu/tieba/pb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948056170, "Lcom/baidu/tieba/pb1;");
        }
    }

    public pb1() {
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

    @JvmStatic
    public static final Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context b2 = rk0.b();
            Intrinsics.checkNotNullExpressionValue(b2, "AdRuntime.applicationContext()");
            return b2;
        }
        return (Context) invokeV.objValue;
    }

    @JvmStatic
    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (so0.b().a().a("nad__web_view_invoke_by_cmd_default", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (so0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (so0.b().a().a("nairobi_kernel_type", ka1.b()) == ka1.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final rb1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (d == null) {
                synchronized (pb1.class) {
                    if (d == null) {
                        d = (rb1) ServiceManager.getService(rb1.a);
                    }
                    if (d == null) {
                        d = rb1.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return d;
        }
        return (rb1) invokeV.objValue;
    }

    @JvmStatic
    public static final f91 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (pb1.class) {
                    if (c == null) {
                        c = (f91) ServiceManager.getService(f91.a);
                    }
                    if (c == null) {
                        c = f91.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return c;
        }
        return (f91) invokeV.objValue;
    }

    @JvmStatic
    public static final d91 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (a == null) {
                synchronized (pb1.class) {
                    if (a == null) {
                        a = (d91) ServiceManager.getService(d91.a);
                    }
                    if (a == null) {
                        a = d91.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return a;
        }
        return (d91) invokeV.objValue;
    }

    @JvmStatic
    public static final sb1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (pb1.class) {
                    if (b == null) {
                        b = (sb1) ServiceManager.getService(sb1.a);
                    }
                    if (b == null) {
                        b = sb1.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return b;
        }
        return (sb1) invokeV.objValue;
    }
}
