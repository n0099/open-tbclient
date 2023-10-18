package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qz2 implements tq2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static Boolean c = null;
    public static int d = -1;
    public static int e = -1;
    public static int f = -1;
    public static int g = -1;
    public static int h = -1;
    public static int i = -1;
    public static int j = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948109056, "Lcom/baidu/tieba/qz2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948109056, "Lcom/baidu/tieba/qz2;");
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f == -1) {
                f = b("swanswitch_file_res_cache_option");
            }
            if (f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (i == -1) {
                i = b("swan_http_interceptor_opt");
            }
            if (i > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (j == -1) {
                j = b("swan_js_thread_opt");
            }
            return j;
        }
        return invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (h == -1) {
                h = b("swan_preload_slave_opt");
            }
            return h;
        }
        return invokeV.intValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (d == -1) {
                d = b("swan_http_thread_opt");
            }
            if (d > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (d == -1) {
                d = b("swan_http_thread_opt");
            }
            int i2 = d;
            if (i2 > 0 && i2 != 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (g == -1) {
                g = b("swan_ubc_samping_opt");
            }
            return g;
        }
        return invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (j() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (c == null) {
                c = Boolean.valueOf(d("swan_js_thread_dispatch"));
            }
            return c.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (e == -1) {
                e = b("swan_webview_ssl_opt");
            }
            if (e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            wo2.g0().getSwitch(str, 0);
            if (tq2.a) {
                Log.d("SwanPerformance", "packing[" + str + " = 0" + PreferencesUtil.RIGHT_MOUNT);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (b(str) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
