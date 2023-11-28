package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.er2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235939, "Lcom/baidu/tieba/vc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235939, "Lcom/baidu/tieba/vc3;");
                return;
            }
        }
        a = sm1.a;
        b = false;
        c = false;
        op2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(hw2 hw2Var, String str, zs1 zs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, hw2Var, str, zs1Var) == null) {
            e(hw2Var, str, zs1Var, null);
        }
    }

    public static void e(hw2 hw2Var, String str, zs1 zs1Var, String str2) {
        h63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, hw2Var, str, zs1Var, str2) != null) || !d || (c0 = h63.c0()) == null) {
            return;
        }
        er2.a X = c0.X();
        kd3 kd3Var = new kd3();
        kd3Var.a = ad3.n(X.H());
        kd3Var.f = X.I();
        if (y32.d()) {
            kd3Var.c = "remote-debug";
        } else if (g23.D()) {
            kd3Var.c = "local-debug";
        } else {
            kd3Var.c = X.U();
        }
        kd3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            kd3Var.e = str;
        }
        if (hw2Var != null) {
            kd3Var.a("path", hw2Var.a);
            kd3Var.a("routeType", hw2Var.e);
            kd3Var.a("routeid", hw2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            kd3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (zs1Var != null && zs1Var.c > 0) {
            kd3Var.a("valuetype", zs1Var.g);
        }
        Bundle Q = X.Q();
        if (Q != null) {
            kd3Var.d(Q.getString("ubc"));
        }
        kd3Var.b(ad3.k(X.X()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + kd3Var.f());
        }
        ad3.onEvent(kd3Var);
    }

    public static hw2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            q52 W = ur2.V().W();
            hw2 hw2Var = null;
            if (W == null) {
                return null;
            }
            n52 j = W.j((W.k() - i) - 1);
            if (j instanceof p52) {
                hw2Var = ((p52) j).t3();
                hw2Var.e = "1";
                hw2Var.f = str;
            }
            g(hw2Var);
            return hw2Var;
        }
        return (hw2) invokeLI.objValue;
    }

    public static void g(hw2 hw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, hw2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(hw2Var, null, null);
            }
        }
    }

    public static void h(hw2 hw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, hw2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(hw2Var, null, null);
        }
    }

    public static void i(hw2 hw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, hw2Var) == null) {
            j(hw2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (vc3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (vc3.class) {
                b = z;
            }
        }
    }

    public static void j(hw2 hw2Var, ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, hw2Var, ai3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + hw2Var + " errCode=" + ai3Var);
            }
            if (c) {
                if (ai3Var == null) {
                    ai3Var = new ai3();
                    ai3Var.k(5L);
                    ai3Var.i(58L);
                    ai3Var.d("route check fail");
                }
                e(hw2Var, "fail", null, String.valueOf(ai3Var.a()));
            }
        }
    }
}
