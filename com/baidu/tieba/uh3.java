package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.dw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210953, "Lcom/baidu/tieba/uh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210953, "Lcom/baidu/tieba/uh3;");
                return;
            }
        }
        a = qr1.a;
        b = false;
        c = false;
        nu2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(g13 g13Var, String str, xx1 xx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, g13Var, str, xx1Var) == null) {
            e(g13Var, str, xx1Var, null);
        }
    }

    public static void e(g13 g13Var, String str, xx1 xx1Var, String str2) {
        gb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, g13Var, str, xx1Var, str2) != null) || !d || (b0 = gb3.b0()) == null) {
            return;
        }
        dw2.a W = b0.W();
        ji3 ji3Var = new ji3();
        ji3Var.a = zh3.n(W.G());
        ji3Var.f = W.H();
        if (x82.d()) {
            ji3Var.c = "remote-debug";
        } else if (f73.D()) {
            ji3Var.c = "local-debug";
        } else {
            ji3Var.c = W.T();
        }
        ji3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            ji3Var.e = str;
        }
        if (g13Var != null) {
            ji3Var.a("path", g13Var.a);
            ji3Var.a("routeType", g13Var.e);
            ji3Var.a("routeid", g13Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            ji3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (xx1Var != null && xx1Var.c > 0) {
            ji3Var.a("valuetype", xx1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            ji3Var.d(P.getString("ubc"));
        }
        ji3Var.b(zh3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + ji3Var.f());
        }
        zh3.onEvent(ji3Var);
    }

    public static g13 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            pa2 U = tw2.T().U();
            g13 g13Var = null;
            if (U == null) {
                return null;
            }
            ma2 j = U.j((U.k() - i) - 1);
            if (j instanceof oa2) {
                g13Var = ((oa2) j).o3();
                g13Var.e = "1";
                g13Var.f = str;
            }
            g(g13Var);
            return g13Var;
        }
        return (g13) invokeLI.objValue;
    }

    public static void g(g13 g13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, g13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(g13Var, null, null);
            }
        }
    }

    public static void h(g13 g13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, g13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(g13Var, null, null);
        }
    }

    public static void i(g13 g13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, g13Var) == null) {
            j(g13Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (uh3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (uh3.class) {
                b = z;
            }
        }
    }

    public static void j(g13 g13Var, zm3 zm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, g13Var, zm3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + g13Var + " errCode=" + zm3Var);
            }
            if (c) {
                if (zm3Var == null) {
                    zm3Var = new zm3();
                    zm3Var.k(5L);
                    zm3Var.i(58L);
                    zm3Var.d("route check fail");
                }
                e(g13Var, "fail", null, String.valueOf(zm3Var.a()));
            }
        }
    }
}
