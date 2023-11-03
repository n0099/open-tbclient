package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.dr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206148, "Lcom/baidu/tieba/uc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206148, "Lcom/baidu/tieba/uc3;");
                return;
            }
        }
        a = rm1.a;
        b = false;
        c = false;
        np2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(gw2 gw2Var, String str, ys1 ys1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gw2Var, str, ys1Var) == null) {
            e(gw2Var, str, ys1Var, null);
        }
    }

    public static void e(gw2 gw2Var, String str, ys1 ys1Var, String str2) {
        g63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, gw2Var, str, ys1Var, str2) != null) || !d || (c0 = g63.c0()) == null) {
            return;
        }
        dr2.a X = c0.X();
        jd3 jd3Var = new jd3();
        jd3Var.a = zc3.n(X.H());
        jd3Var.f = X.I();
        if (x32.d()) {
            jd3Var.c = "remote-debug";
        } else if (f23.D()) {
            jd3Var.c = "local-debug";
        } else {
            jd3Var.c = X.U();
        }
        jd3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            jd3Var.e = str;
        }
        if (gw2Var != null) {
            jd3Var.a("path", gw2Var.a);
            jd3Var.a("routeType", gw2Var.e);
            jd3Var.a("routeid", gw2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            jd3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (ys1Var != null && ys1Var.c > 0) {
            jd3Var.a("valuetype", ys1Var.g);
        }
        Bundle Q = X.Q();
        if (Q != null) {
            jd3Var.d(Q.getString("ubc"));
        }
        jd3Var.b(zc3.k(X.X()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + jd3Var.f());
        }
        zc3.onEvent(jd3Var);
    }

    public static gw2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            p52 W = tr2.V().W();
            gw2 gw2Var = null;
            if (W == null) {
                return null;
            }
            m52 j = W.j((W.k() - i) - 1);
            if (j instanceof o52) {
                gw2Var = ((o52) j).t3();
                gw2Var.e = "1";
                gw2Var.f = str;
            }
            g(gw2Var);
            return gw2Var;
        }
        return (gw2) invokeLI.objValue;
    }

    public static void g(gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, gw2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(gw2Var, null, null);
            }
        }
    }

    public static void h(gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, gw2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(gw2Var, null, null);
        }
    }

    public static void i(gw2 gw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, gw2Var) == null) {
            j(gw2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (uc3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (uc3.class) {
                b = z;
            }
        }
    }

    public static void j(gw2 gw2Var, zh3 zh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, gw2Var, zh3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + gw2Var + " errCode=" + zh3Var);
            }
            if (c) {
                if (zh3Var == null) {
                    zh3Var = new zh3();
                    zh3Var.k(5L);
                    zh3Var.i(58L);
                    zh3Var.d("route check fail");
                }
                e(gw2Var, "fail", null, String.valueOf(zh3Var.a()));
            }
        }
    }
}
