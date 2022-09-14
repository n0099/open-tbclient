package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947927458, "Lcom/baidu/tieba/m93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947927458, "Lcom/baidu/tieba/m93;");
                return;
            }
        }
        a = ij1.a;
        b = false;
        c = false;
        fm2.g0().getSwitch("swan_app_use_route_statistic", false);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b : invokeV.booleanValue;
    }

    public static void d(ys2 ys2Var, String str, pp1 pp1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ys2Var, str, pp1Var) == null) {
            e(ys2Var, str, pp1Var, null);
        }
    }

    public static void e(ys2 ys2Var, String str, pp1 pp1Var, String str2) {
        y23 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, ys2Var, str, pp1Var, str2) == null) && d && (b0 = y23.b0()) != null) {
            vn2.a W = b0.W();
            ba3 ba3Var = new ba3();
            ba3Var.a = r93.n(W.G());
            ba3Var.f = W.H();
            if (p02.d()) {
                ba3Var.c = "remote-debug";
            } else if (xy2.D()) {
                ba3Var.c = "local-debug";
            } else {
                ba3Var.c = W.T();
            }
            ba3Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                ba3Var.e = str;
            }
            if (ys2Var != null) {
                ba3Var.a("path", ys2Var.a);
                ba3Var.a("routeType", ys2Var.e);
                ba3Var.a("routeid", ys2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                ba3Var.a("errcode", str2);
            }
            if (pp1Var != null && pp1Var.c > 0) {
                ba3Var.a("valuetype", pp1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                ba3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            ba3Var.b(r93.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + ba3Var.f());
            }
            r93.onEvent(ba3Var);
        }
    }

    public static ys2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            h22 V = lo2.U().V();
            ys2 ys2Var = null;
            if (V == null) {
                return null;
            }
            e22 j = V.j((V.k() - i) - 1);
            if (j instanceof g22) {
                ys2Var = ((g22) j).m3();
                ys2Var.e = "1";
                ys2Var.f = str;
            }
            g(ys2Var);
            return ys2Var;
        }
        return (ys2) invokeLI.objValue;
    }

    public static void g(ys2 ys2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, ys2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(ys2Var, null, null);
        }
    }

    public static void h(ys2 ys2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ys2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(ys2Var, null, null);
        }
    }

    public static void i(ys2 ys2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ys2Var) == null) {
            j(ys2Var, null);
        }
    }

    public static void j(ys2 ys2Var, re3 re3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, ys2Var, re3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + ys2Var + " errCode=" + re3Var);
            }
            if (c) {
                if (re3Var == null) {
                    re3Var = new re3();
                    re3Var.k(5L);
                    re3Var.i(58L);
                    re3Var.d("route check fail");
                }
                e(ys2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(re3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (m93.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (m93.class) {
                b = z;
            }
        }
    }
}
