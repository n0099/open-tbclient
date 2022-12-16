package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.bp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948144644, "Lcom/baidu/tieba/sa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948144644, "Lcom/baidu/tieba/sa3;");
                return;
            }
        }
        a = ok1.a;
        b = false;
        c = false;
        ln2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(eu2 eu2Var, String str, vq1 vq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eu2Var, str, vq1Var) == null) {
            e(eu2Var, str, vq1Var, null);
        }
    }

    public static void e(eu2 eu2Var, String str, vq1 vq1Var, String str2) {
        e43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, eu2Var, str, vq1Var, str2) != null) || !d || (b0 = e43.b0()) == null) {
            return;
        }
        bp2.a W = b0.W();
        hb3 hb3Var = new hb3();
        hb3Var.a = xa3.n(W.G());
        hb3Var.f = W.H();
        if (v12.d()) {
            hb3Var.c = "remote-debug";
        } else if (d03.D()) {
            hb3Var.c = "local-debug";
        } else {
            hb3Var.c = W.T();
        }
        hb3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            hb3Var.e = str;
        }
        if (eu2Var != null) {
            hb3Var.a("path", eu2Var.a);
            hb3Var.a("routeType", eu2Var.e);
            hb3Var.a("routeid", eu2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            hb3Var.a("errcode", str2);
        }
        if (vq1Var != null && vq1Var.c > 0) {
            hb3Var.a("valuetype", vq1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            hb3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        hb3Var.b(xa3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + hb3Var.f());
        }
        xa3.onEvent(hb3Var);
    }

    public static eu2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            n32 V = rp2.U().V();
            eu2 eu2Var = null;
            if (V == null) {
                return null;
            }
            k32 j = V.j((V.k() - i) - 1);
            if (j instanceof m32) {
                eu2Var = ((m32) j).m3();
                eu2Var.e = "1";
                eu2Var.f = str;
            }
            g(eu2Var);
            return eu2Var;
        }
        return (eu2) invokeLI.objValue;
    }

    public static void g(eu2 eu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, eu2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(eu2Var, null, null);
            }
        }
    }

    public static void h(eu2 eu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, eu2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(eu2Var, null, null);
        }
    }

    public static void i(eu2 eu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, eu2Var) == null) {
            j(eu2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (sa3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (sa3.class) {
                b = z;
            }
        }
    }

    public static void j(eu2 eu2Var, xf3 xf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, eu2Var, xf3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + eu2Var + " errCode=" + xf3Var);
            }
            if (c) {
                if (xf3Var == null) {
                    xf3Var = new xf3();
                    xf3Var.k(5L);
                    xf3Var.i(58L);
                    xf3Var.d("route check fail");
                }
                e(eu2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(xf3Var.a()));
            }
        }
    }
}
