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
public final class n51 {
    public static /* synthetic */ Interceptable $ic;
    public static c31 a;
    public static q51 b;
    public static e31 c;
    public static p51 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947953343, "Lcom/baidu/tieba/n51;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947953343, "Lcom/baidu/tieba/n51;");
        }
    }

    public n51() {
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
            Context b2 = pe0.b();
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
            if (qi0.b().a().a("nad__web_view_invoke_by_cmd_default", 1) == 1) {
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
            if (qi0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
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
            if (qi0.b().a().a("nairobi_kernel_type", i41.b()) == i41.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final p51 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (d == null) {
                synchronized (n51.class) {
                    if (d == null) {
                        d = (p51) ServiceManager.getService(p51.a);
                    }
                    if (d == null) {
                        d = p51.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return d;
        }
        return (p51) invokeV.objValue;
    }

    @JvmStatic
    public static final e31 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (n51.class) {
                    if (c == null) {
                        c = (e31) ServiceManager.getService(e31.a);
                    }
                    if (c == null) {
                        c = e31.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return c;
        }
        return (e31) invokeV.objValue;
    }

    @JvmStatic
    public static final c31 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (a == null) {
                synchronized (n51.class) {
                    if (a == null) {
                        a = (c31) ServiceManager.getService(c31.a);
                    }
                    if (a == null) {
                        a = c31.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return a;
        }
        return (c31) invokeV.objValue;
    }

    @JvmStatic
    public static final q51 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (n51.class) {
                    if (b == null) {
                        b = (q51) ServiceManager.getService(q51.a);
                    }
                    if (b == null) {
                        b = q51.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return b;
        }
        return (q51) invokeV.objValue;
    }
}
