package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ta3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948174435, "Lcom/baidu/tieba/ta3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948174435, "Lcom/baidu/tieba/ta3;");
                return;
            }
        }
        a = pk1.a;
        b = false;
        c = false;
        mn2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(fu2 fu2Var, String str, wq1 wq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fu2Var, str, wq1Var) == null) {
            e(fu2Var, str, wq1Var, null);
        }
    }

    public static void e(fu2 fu2Var, String str, wq1 wq1Var, String str2) {
        f43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, fu2Var, str, wq1Var, str2) != null) || !d || (b0 = f43.b0()) == null) {
            return;
        }
        cp2.a W = b0.W();
        ib3 ib3Var = new ib3();
        ib3Var.a = ya3.n(W.G());
        ib3Var.f = W.H();
        if (w12.d()) {
            ib3Var.c = "remote-debug";
        } else if (e03.D()) {
            ib3Var.c = "local-debug";
        } else {
            ib3Var.c = W.T();
        }
        ib3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            ib3Var.e = str;
        }
        if (fu2Var != null) {
            ib3Var.a("path", fu2Var.a);
            ib3Var.a("routeType", fu2Var.e);
            ib3Var.a("routeid", fu2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            ib3Var.a("errcode", str2);
        }
        if (wq1Var != null && wq1Var.c > 0) {
            ib3Var.a("valuetype", wq1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            ib3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        ib3Var.b(ya3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + ib3Var.f());
        }
        ya3.onEvent(ib3Var);
    }

    public static fu2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            o32 V = sp2.U().V();
            fu2 fu2Var = null;
            if (V == null) {
                return null;
            }
            l32 j = V.j((V.k() - i) - 1);
            if (j instanceof n32) {
                fu2Var = ((n32) j).m3();
                fu2Var.e = "1";
                fu2Var.f = str;
            }
            g(fu2Var);
            return fu2Var;
        }
        return (fu2) invokeLI.objValue;
    }

    public static void g(fu2 fu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, fu2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(fu2Var, null, null);
            }
        }
    }

    public static void h(fu2 fu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, fu2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(fu2Var, null, null);
        }
    }

    public static void i(fu2 fu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, fu2Var) == null) {
            j(fu2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (ta3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (ta3.class) {
                b = z;
            }
        }
    }

    public static void j(fu2 fu2Var, yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, fu2Var, yf3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + fu2Var + " errCode=" + yf3Var);
            }
            if (c) {
                if (yf3Var == null) {
                    yf3Var = new yf3();
                    yf3Var.k(5L);
                    yf3Var.i(58L);
                    yf3Var.d("route check fail");
                }
                e(fu2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(yf3Var.a()));
            }
        }
    }
}
