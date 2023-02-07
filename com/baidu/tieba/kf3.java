package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.tt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947911121, "Lcom/baidu/tieba/kf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947911121, "Lcom/baidu/tieba/kf3;");
                return;
            }
        }
        a = gp1.a;
        b = false;
        c = false;
        ds2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(wy2 wy2Var, String str, nv1 nv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, wy2Var, str, nv1Var) == null) {
            e(wy2Var, str, nv1Var, null);
        }
    }

    public static void e(wy2 wy2Var, String str, nv1 nv1Var, String str2) {
        w83 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, wy2Var, str, nv1Var, str2) != null) || !d || (b0 = w83.b0()) == null) {
            return;
        }
        tt2.a W = b0.W();
        zf3 zf3Var = new zf3();
        zf3Var.a = pf3.n(W.G());
        zf3Var.f = W.H();
        if (n62.d()) {
            zf3Var.c = "remote-debug";
        } else if (v43.D()) {
            zf3Var.c = "local-debug";
        } else {
            zf3Var.c = W.T();
        }
        zf3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            zf3Var.e = str;
        }
        if (wy2Var != null) {
            zf3Var.a("path", wy2Var.a);
            zf3Var.a("routeType", wy2Var.e);
            zf3Var.a("routeid", wy2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            zf3Var.a("errcode", str2);
        }
        if (nv1Var != null && nv1Var.c > 0) {
            zf3Var.a("valuetype", nv1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            zf3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        zf3Var.b(pf3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + zf3Var.f());
        }
        pf3.onEvent(zf3Var);
    }

    public static wy2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            f82 V = ju2.U().V();
            wy2 wy2Var = null;
            if (V == null) {
                return null;
            }
            c82 j = V.j((V.k() - i) - 1);
            if (j instanceof e82) {
                wy2Var = ((e82) j).m3();
                wy2Var.e = "1";
                wy2Var.f = str;
            }
            g(wy2Var);
            return wy2Var;
        }
        return (wy2) invokeLI.objValue;
    }

    public static void g(wy2 wy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, wy2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(wy2Var, null, null);
            }
        }
    }

    public static void h(wy2 wy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, wy2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(wy2Var, null, null);
        }
    }

    public static void i(wy2 wy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, wy2Var) == null) {
            j(wy2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (kf3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (kf3.class) {
                b = z;
            }
        }
    }

    public static void j(wy2 wy2Var, pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, wy2Var, pk3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + wy2Var + " errCode=" + pk3Var);
            }
            if (c) {
                if (pk3Var == null) {
                    pk3Var = new pk3();
                    pk3Var.k(5L);
                    pk3Var.i(58L);
                    pk3Var.d("route check fail");
                }
                e(wy2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(pk3Var.a()));
            }
        }
    }
}
