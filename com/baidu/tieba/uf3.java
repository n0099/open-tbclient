package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class uf3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948209031, "Lcom/baidu/tieba/uf3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948209031, "Lcom/baidu/tieba/uf3;");
                return;
            }
        }
        a = qp1.a;
        b = false;
        c = false;
        ns2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(gz2 gz2Var, String str, xv1 xv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, gz2Var, str, xv1Var) == null) {
            e(gz2Var, str, xv1Var, null);
        }
    }

    public static void e(gz2 gz2Var, String str, xv1 xv1Var, String str2) {
        g93 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, gz2Var, str, xv1Var, str2) != null) || !d || (b0 = g93.b0()) == null) {
            return;
        }
        du2.a W = b0.W();
        jg3 jg3Var = new jg3();
        jg3Var.a = zf3.n(W.G());
        jg3Var.f = W.H();
        if (x62.d()) {
            jg3Var.c = "remote-debug";
        } else if (f53.D()) {
            jg3Var.c = "local-debug";
        } else {
            jg3Var.c = W.T();
        }
        jg3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            jg3Var.e = str;
        }
        if (gz2Var != null) {
            jg3Var.a("path", gz2Var.a);
            jg3Var.a("routeType", gz2Var.e);
            jg3Var.a("routeid", gz2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            jg3Var.a("errcode", str2);
        }
        if (xv1Var != null && xv1Var.c > 0) {
            jg3Var.a("valuetype", xv1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            jg3Var.d(P.getString("ubc"));
        }
        jg3Var.b(zf3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + jg3Var.f());
        }
        zf3.onEvent(jg3Var);
    }

    public static gz2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            p82 V = tu2.U().V();
            gz2 gz2Var = null;
            if (V == null) {
                return null;
            }
            m82 j = V.j((V.k() - i) - 1);
            if (j instanceof o82) {
                gz2Var = ((o82) j).p3();
                gz2Var.e = "1";
                gz2Var.f = str;
            }
            g(gz2Var);
            return gz2Var;
        }
        return (gz2) invokeLI.objValue;
    }

    public static void g(gz2 gz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, gz2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(gz2Var, null, null);
            }
        }
    }

    public static void h(gz2 gz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, gz2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(gz2Var, null, null);
        }
    }

    public static void i(gz2 gz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, gz2Var) == null) {
            j(gz2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (uf3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (uf3.class) {
                b = z;
            }
        }
    }

    public static void j(gz2 gz2Var, zk3 zk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, gz2Var, zk3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + gz2Var + " errCode=" + zk3Var);
            }
            if (c) {
                if (zk3Var == null) {
                    zk3Var = new zk3();
                    zk3Var.k(5L);
                    zk3Var.i(58L);
                    zk3Var.d("route check fail");
                }
                e(gz2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(zk3Var.a()));
            }
        }
    }
}
