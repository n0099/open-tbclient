package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ni3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948003377, "Lcom/baidu/tieba/ni3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948003377, "Lcom/baidu/tieba/ni3;");
                return;
            }
        }
        a = js1.a;
        b = false;
        c = false;
        gv2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(z13 z13Var, String str, qy1 qy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, z13Var, str, qy1Var) == null) {
            e(z13Var, str, qy1Var, null);
        }
    }

    public static void e(z13 z13Var, String str, qy1 qy1Var, String str2) {
        zb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, z13Var, str, qy1Var, str2) != null) || !d || (b0 = zb3.b0()) == null) {
            return;
        }
        ww2.a W = b0.W();
        cj3 cj3Var = new cj3();
        cj3Var.a = si3.n(W.G());
        cj3Var.f = W.H();
        if (q92.d()) {
            cj3Var.c = "remote-debug";
        } else if (y73.D()) {
            cj3Var.c = "local-debug";
        } else {
            cj3Var.c = W.T();
        }
        cj3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            cj3Var.e = str;
        }
        if (z13Var != null) {
            cj3Var.a("path", z13Var.a);
            cj3Var.a("routeType", z13Var.e);
            cj3Var.a("routeid", z13Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            cj3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (qy1Var != null && qy1Var.c > 0) {
            cj3Var.a("valuetype", qy1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            cj3Var.d(P.getString("ubc"));
        }
        cj3Var.b(si3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + cj3Var.f());
        }
        si3.onEvent(cj3Var);
    }

    public static z13 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            ib2 U = mx2.T().U();
            z13 z13Var = null;
            if (U == null) {
                return null;
            }
            fb2 j = U.j((U.k() - i) - 1);
            if (j instanceof hb2) {
                z13Var = ((hb2) j).o3();
                z13Var.e = "1";
                z13Var.f = str;
            }
            g(z13Var);
            return z13Var;
        }
        return (z13) invokeLI.objValue;
    }

    public static void g(z13 z13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, z13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(z13Var, null, null);
            }
        }
    }

    public static void h(z13 z13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, z13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(z13Var, null, null);
        }
    }

    public static void i(z13 z13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, z13Var) == null) {
            j(z13Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (ni3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (ni3.class) {
                b = z;
            }
        }
    }

    public static void j(z13 z13Var, sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, z13Var, sn3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + z13Var + " errCode=" + sn3Var);
            }
            if (c) {
                if (sn3Var == null) {
                    sn3Var = new sn3();
                    sn3Var.k(5L);
                    sn3Var.i(58L);
                    sn3Var.d("route check fail");
                }
                e(z13Var, "fail", null, String.valueOf(sn3Var.a()));
            }
        }
    }
}
