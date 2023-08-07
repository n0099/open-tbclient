package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mh3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947972625, "Lcom/baidu/tieba/mh3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947972625, "Lcom/baidu/tieba/mh3;");
                return;
            }
        }
        a = ir1.a;
        b = false;
        c = false;
        fu2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(y03 y03Var, String str, px1 px1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, y03Var, str, px1Var) == null) {
            e(y03Var, str, px1Var, null);
        }
    }

    public static void e(y03 y03Var, String str, px1 px1Var, String str2) {
        ya3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, y03Var, str, px1Var, str2) != null) || !d || (b0 = ya3.b0()) == null) {
            return;
        }
        vv2.a W = b0.W();
        bi3 bi3Var = new bi3();
        bi3Var.a = rh3.n(W.G());
        bi3Var.f = W.H();
        if (p82.d()) {
            bi3Var.c = "remote-debug";
        } else if (x63.D()) {
            bi3Var.c = "local-debug";
        } else {
            bi3Var.c = W.T();
        }
        bi3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            bi3Var.e = str;
        }
        if (y03Var != null) {
            bi3Var.a("path", y03Var.a);
            bi3Var.a("routeType", y03Var.e);
            bi3Var.a("routeid", y03Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            bi3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (px1Var != null && px1Var.c > 0) {
            bi3Var.a("valuetype", px1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            bi3Var.d(P.getString("ubc"));
        }
        bi3Var.b(rh3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + bi3Var.f());
        }
        rh3.onEvent(bi3Var);
    }

    public static y03 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            ha2 U = lw2.T().U();
            y03 y03Var = null;
            if (U == null) {
                return null;
            }
            ea2 j = U.j((U.k() - i) - 1);
            if (j instanceof ga2) {
                y03Var = ((ga2) j).o3();
                y03Var.e = "1";
                y03Var.f = str;
            }
            g(y03Var);
            return y03Var;
        }
        return (y03) invokeLI.objValue;
    }

    public static void g(y03 y03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, y03Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(y03Var, null, null);
            }
        }
    }

    public static void h(y03 y03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, y03Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(y03Var, null, null);
        }
    }

    public static void i(y03 y03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, y03Var) == null) {
            j(y03Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (mh3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (mh3.class) {
                b = z;
            }
        }
    }

    public static void j(y03 y03Var, rm3 rm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, y03Var, rm3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + y03Var + " errCode=" + rm3Var);
            }
            if (c) {
                if (rm3Var == null) {
                    rm3Var = new rm3();
                    rm3Var.k(5L);
                    rm3Var.i(58L);
                    rm3Var.d("route check fail");
                }
                e(y03Var, "fail", null, String.valueOf(rm3Var.a()));
            }
        }
    }
}
