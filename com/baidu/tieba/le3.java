package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class le3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939951, "Lcom/baidu/tieba/le3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939951, "Lcom/baidu/tieba/le3;");
                return;
            }
        }
        a = ho1.a;
        b = false;
        c = false;
        er2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(xx2 xx2Var, String str, ou1 ou1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xx2Var, str, ou1Var) == null) {
            e(xx2Var, str, ou1Var, null);
        }
    }

    public static void e(xx2 xx2Var, String str, ou1 ou1Var, String str2) {
        x73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, xx2Var, str, ou1Var, str2) != null) || !d || (b0 = x73.b0()) == null) {
            return;
        }
        us2.a W = b0.W();
        af3 af3Var = new af3();
        af3Var.a = qe3.n(W.G());
        af3Var.f = W.H();
        if (o52.d()) {
            af3Var.c = "remote-debug";
        } else if (w33.D()) {
            af3Var.c = "local-debug";
        } else {
            af3Var.c = W.T();
        }
        af3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            af3Var.e = str;
        }
        if (xx2Var != null) {
            af3Var.a("path", xx2Var.a);
            af3Var.a("routeType", xx2Var.e);
            af3Var.a("routeid", xx2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            af3Var.a("errcode", str2);
        }
        if (ou1Var != null && ou1Var.c > 0) {
            af3Var.a("valuetype", ou1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            af3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        af3Var.b(qe3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + af3Var.f());
        }
        qe3.onEvent(af3Var);
    }

    public static xx2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            g72 V = kt2.U().V();
            xx2 xx2Var = null;
            if (V == null) {
                return null;
            }
            d72 j = V.j((V.k() - i) - 1);
            if (j instanceof f72) {
                xx2Var = ((f72) j).p3();
                xx2Var.e = "1";
                xx2Var.f = str;
            }
            g(xx2Var);
            return xx2Var;
        }
        return (xx2) invokeLI.objValue;
    }

    public static void g(xx2 xx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, xx2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(xx2Var, null, null);
            }
        }
    }

    public static void h(xx2 xx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, xx2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(xx2Var, null, null);
        }
    }

    public static void i(xx2 xx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, xx2Var) == null) {
            j(xx2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (le3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (le3.class) {
                b = z;
            }
        }
    }

    public static void j(xx2 xx2Var, qj3 qj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, xx2Var, qj3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + xx2Var + " errCode=" + qj3Var);
            }
            if (c) {
                if (qj3Var == null) {
                    qj3Var = new qj3();
                    qj3Var.k(5L);
                    qj3Var.i(58L);
                    qj3Var.d("route check fail");
                }
                e(xx2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(qj3Var.a()));
            }
        }
    }
}
