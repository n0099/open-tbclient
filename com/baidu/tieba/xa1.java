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
/* loaded from: classes8.dex */
public final class xa1 {
    public static /* synthetic */ Interceptable $ic;
    public static l81 a;
    public static ab1 b;
    public static n81 c;
    public static za1 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948293537, "Lcom/baidu/tieba/xa1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948293537, "Lcom/baidu/tieba/xa1;");
        }
    }

    public xa1() {
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
            Context b2 = sj0.b();
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
            if (tn0.b().a().a("nad__web_view_invoke_by_cmd_default", 1) == 1) {
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
            if (tn0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
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
            if (tn0.b().a().a("nairobi_kernel_type", s91.b()) == s91.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final za1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (d == null) {
                synchronized (xa1.class) {
                    if (d == null) {
                        d = (za1) ServiceManager.getService(za1.a);
                    }
                    if (d == null) {
                        d = za1.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return d;
        }
        return (za1) invokeV.objValue;
    }

    @JvmStatic
    public static final n81 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (xa1.class) {
                    if (c == null) {
                        c = (n81) ServiceManager.getService(n81.a);
                    }
                    if (c == null) {
                        c = n81.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return c;
        }
        return (n81) invokeV.objValue;
    }

    @JvmStatic
    public static final l81 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (a == null) {
                synchronized (xa1.class) {
                    if (a == null) {
                        a = (l81) ServiceManager.getService(l81.a);
                    }
                    if (a == null) {
                        a = l81.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return a;
        }
        return (l81) invokeV.objValue;
    }

    @JvmStatic
    public static final ab1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (xa1.class) {
                    if (b == null) {
                        b = (ab1) ServiceManager.getService(ab1.a);
                    }
                    if (b == null) {
                        b = ab1.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return b;
        }
        return (ab1) invokeV.objValue;
    }
}
