package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public static final int c;
    public static int d;
    public static int e;
    public static final boolean f;
    public static boolean g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948342579, "Lcom/baidu/tieba/yu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948342579, "Lcom/baidu/tieba/yu2;");
                return;
            }
        }
        a = kh1.a;
        d = -1;
        e = -1;
        b = f("swan_get_swan_id_cache");
        hk2.g0().getSwitch("swan_pms_use_outback_switch", 0);
        hk2.g0().getSwitch("swan_preload_game_strategy", 0);
        c = 0;
        f = f("swan_670_append_request_info");
        hk2.g0().getSwitch("swan_description_online_control", 0);
        fd4.a = 0;
        hk2.g0().getSwitch("swan_bdtls_use_cache", false);
        g = false;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == -1) {
                hk2.g0().getSwitch("swan_use_extra_connect_pool", 0);
                e = 0;
            }
            return e;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == -1) {
                hk2.g0().getSwitch("swan_upgrade_js_thread_priority", 0);
                d = 0;
            }
            return d;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? g : invokeV.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c : invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b : invokeV.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            hk2.g0().getSwitch(str, 0);
            if (a) {
                Log.d("SwanApiCostOpt", str + " value : 0");
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
