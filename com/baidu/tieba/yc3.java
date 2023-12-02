package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class yc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325312, "Lcom/baidu/tieba/yc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325312, "Lcom/baidu/tieba/yc3;");
                return;
            }
        }
        a = vm1.a;
        b = false;
        c = false;
        rp2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(kw2 kw2Var, String str, ct1 ct1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, kw2Var, str, ct1Var) == null) {
            e(kw2Var, str, ct1Var, null);
        }
    }

    public static void e(kw2 kw2Var, String str, ct1 ct1Var, String str2) {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, kw2Var, str, ct1Var, str2) != null) || !d || (c0 = k63.c0()) == null) {
            return;
        }
        hr2.a X = c0.X();
        nd3 nd3Var = new nd3();
        nd3Var.a = dd3.n(X.H());
        nd3Var.f = X.I();
        if (b42.d()) {
            nd3Var.c = "remote-debug";
        } else if (j23.D()) {
            nd3Var.c = "local-debug";
        } else {
            nd3Var.c = X.U();
        }
        nd3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            nd3Var.e = str;
        }
        if (kw2Var != null) {
            nd3Var.a("path", kw2Var.a);
            nd3Var.a("routeType", kw2Var.e);
            nd3Var.a("routeid", kw2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            nd3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (ct1Var != null && ct1Var.c > 0) {
            nd3Var.a("valuetype", ct1Var.g);
        }
        Bundle Q = X.Q();
        if (Q != null) {
            nd3Var.d(Q.getString("ubc"));
        }
        nd3Var.b(dd3.k(X.X()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + nd3Var.f());
        }
        dd3.onEvent(nd3Var);
    }

    public static kw2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            t52 W = xr2.V().W();
            kw2 kw2Var = null;
            if (W == null) {
                return null;
            }
            q52 j = W.j((W.k() - i) - 1);
            if (j instanceof s52) {
                kw2Var = ((s52) j).t3();
                kw2Var.e = "1";
                kw2Var.f = str;
            }
            g(kw2Var);
            return kw2Var;
        }
        return (kw2) invokeLI.objValue;
    }

    public static void g(kw2 kw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, kw2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(kw2Var, null, null);
            }
        }
    }

    public static void h(kw2 kw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, kw2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(kw2Var, null, null);
        }
    }

    public static void i(kw2 kw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, kw2Var) == null) {
            j(kw2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (yc3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (yc3.class) {
                b = z;
            }
        }
    }

    public static void j(kw2 kw2Var, di3 di3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, kw2Var, di3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + kw2Var + " errCode=" + di3Var);
            }
            if (c) {
                if (di3Var == null) {
                    di3Var = new di3();
                    di3Var.k(5L);
                    di3Var.i(58L);
                    di3Var.d("route check fail");
                }
                e(kw2Var, "fail", null, String.valueOf(di3Var.a()));
            }
        }
    }
}
