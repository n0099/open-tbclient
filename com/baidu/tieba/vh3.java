package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.ew2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948240744, "Lcom/baidu/tieba/vh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948240744, "Lcom/baidu/tieba/vh3;");
                return;
            }
        }
        a = rr1.a;
        b = false;
        c = false;
        ou2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(h13 h13Var, String str, yx1 yx1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, h13Var, str, yx1Var) == null) {
            e(h13Var, str, yx1Var, null);
        }
    }

    public static void e(h13 h13Var, String str, yx1 yx1Var, String str2) {
        hb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, h13Var, str, yx1Var, str2) != null) || !d || (b0 = hb3.b0()) == null) {
            return;
        }
        ew2.a W = b0.W();
        ki3 ki3Var = new ki3();
        ki3Var.a = ai3.n(W.G());
        ki3Var.f = W.H();
        if (y82.d()) {
            ki3Var.c = "remote-debug";
        } else if (g73.D()) {
            ki3Var.c = "local-debug";
        } else {
            ki3Var.c = W.T();
        }
        ki3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            ki3Var.e = str;
        }
        if (h13Var != null) {
            ki3Var.a("path", h13Var.a);
            ki3Var.a("routeType", h13Var.e);
            ki3Var.a("routeid", h13Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            ki3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (yx1Var != null && yx1Var.c > 0) {
            ki3Var.a("valuetype", yx1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            ki3Var.d(P.getString("ubc"));
        }
        ki3Var.b(ai3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + ki3Var.f());
        }
        ai3.onEvent(ki3Var);
    }

    public static h13 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            qa2 U = uw2.T().U();
            h13 h13Var = null;
            if (U == null) {
                return null;
            }
            na2 j = U.j((U.k() - i) - 1);
            if (j instanceof pa2) {
                h13Var = ((pa2) j).o3();
                h13Var.e = "1";
                h13Var.f = str;
            }
            g(h13Var);
            return h13Var;
        }
        return (h13) invokeLI.objValue;
    }

    public static void g(h13 h13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, h13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(h13Var, null, null);
            }
        }
    }

    public static void h(h13 h13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, h13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(h13Var, null, null);
        }
    }

    public static void i(h13 h13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, h13Var) == null) {
            j(h13Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (vh3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (vh3.class) {
                b = z;
            }
        }
    }

    public static void j(h13 h13Var, an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, h13Var, an3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + h13Var + " errCode=" + an3Var);
            }
            if (c) {
                if (an3Var == null) {
                    an3Var = new an3();
                    an3Var.k(5L);
                    an3Var.i(58L);
                    an3Var.d("route check fail");
                }
                e(h13Var, "fail", null, String.valueOf(an3Var.a()));
            }
        }
    }
}
