package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.aw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121580, "Lcom/baidu/tieba/rh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121580, "Lcom/baidu/tieba/rh3;");
                return;
            }
        }
        a = nr1.a;
        b = false;
        c = false;
        ku2.g0().getSwitch("swan_app_use_route_statistic", false);
        d = false;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "mIsStartByApi = " + c);
            }
            boolean z = c;
            k(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "mIsStartFirstPage = " + b);
            }
            boolean z = b;
            l(false);
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b;
        }
        return invokeV.booleanValue;
    }

    public static void d(d13 d13Var, String str, ux1 ux1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, d13Var, str, ux1Var) == null) {
            e(d13Var, str, ux1Var, null);
        }
    }

    public static void e(d13 d13Var, String str, ux1 ux1Var, String str2) {
        db3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, d13Var, str, ux1Var, str2) != null) || !d || (b0 = db3.b0()) == null) {
            return;
        }
        aw2.a W = b0.W();
        gi3 gi3Var = new gi3();
        gi3Var.a = wh3.n(W.G());
        gi3Var.f = W.H();
        if (u82.d()) {
            gi3Var.c = "remote-debug";
        } else if (c73.D()) {
            gi3Var.c = "local-debug";
        } else {
            gi3Var.c = W.T();
        }
        gi3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            gi3Var.e = str;
        }
        if (d13Var != null) {
            gi3Var.a("path", d13Var.a);
            gi3Var.a("routeType", d13Var.e);
            gi3Var.a("routeid", d13Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            gi3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (ux1Var != null && ux1Var.c > 0) {
            gi3Var.a("valuetype", ux1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            gi3Var.d(P.getString("ubc"));
        }
        gi3Var.b(wh3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + gi3Var.f());
        }
        wh3.onEvent(gi3Var);
    }

    public static d13 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            ma2 U = qw2.T().U();
            d13 d13Var = null;
            if (U == null) {
                return null;
            }
            ja2 j = U.j((U.k() - i) - 1);
            if (j instanceof la2) {
                d13Var = ((la2) j).o3();
                d13Var.e = "1";
                d13Var.f = str;
            }
            g(d13Var);
            return d13Var;
        }
        return (d13) invokeLI.objValue;
    }

    public static void g(d13 d13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, d13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(d13Var, null, null);
            }
        }
    }

    public static void h(d13 d13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, d13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(d13Var, null, null);
        }
    }

    public static void i(d13 d13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, d13Var) == null) {
            j(d13Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (rh3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (rh3.class) {
                b = z;
            }
        }
    }

    public static void j(d13 d13Var, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, d13Var, wm3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + d13Var + " errCode=" + wm3Var);
            }
            if (c) {
                if (wm3Var == null) {
                    wm3Var = new wm3();
                    wm3Var.k(5L);
                    wm3Var.i(58L);
                    wm3Var.d("route check fail");
                }
                e(d13Var, "fail", null, String.valueOf(wm3Var.a()));
            }
        }
    }
}
