package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class je3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947880369, "Lcom/baidu/tieba/je3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947880369, "Lcom/baidu/tieba/je3;");
                return;
            }
        }
        a = fo1.a;
        b = false;
        c = false;
        cr2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(vx2 vx2Var, String str, mu1 mu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vx2Var, str, mu1Var) == null) {
            e(vx2Var, str, mu1Var, null);
        }
    }

    public static void e(vx2 vx2Var, String str, mu1 mu1Var, String str2) {
        v73 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, vx2Var, str, mu1Var, str2) != null) || !d || (b0 = v73.b0()) == null) {
            return;
        }
        ss2.a W = b0.W();
        ye3 ye3Var = new ye3();
        ye3Var.a = oe3.n(W.G());
        ye3Var.f = W.H();
        if (m52.d()) {
            ye3Var.c = "remote-debug";
        } else if (u33.D()) {
            ye3Var.c = "local-debug";
        } else {
            ye3Var.c = W.T();
        }
        ye3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            ye3Var.e = str;
        }
        if (vx2Var != null) {
            ye3Var.a("path", vx2Var.a);
            ye3Var.a("routeType", vx2Var.e);
            ye3Var.a("routeid", vx2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            ye3Var.a("errcode", str2);
        }
        if (mu1Var != null && mu1Var.c > 0) {
            ye3Var.a("valuetype", mu1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            ye3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        ye3Var.b(oe3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + ye3Var.f());
        }
        oe3.onEvent(ye3Var);
    }

    public static vx2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            e72 V = it2.U().V();
            vx2 vx2Var = null;
            if (V == null) {
                return null;
            }
            b72 j = V.j((V.k() - i) - 1);
            if (j instanceof d72) {
                vx2Var = ((d72) j).p3();
                vx2Var.e = "1";
                vx2Var.f = str;
            }
            g(vx2Var);
            return vx2Var;
        }
        return (vx2) invokeLI.objValue;
    }

    public static void g(vx2 vx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, vx2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(vx2Var, null, null);
            }
        }
    }

    public static void h(vx2 vx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, vx2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(vx2Var, null, null);
        }
    }

    public static void i(vx2 vx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, vx2Var) == null) {
            j(vx2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (je3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (je3.class) {
                b = z;
            }
        }
    }

    public static void j(vx2 vx2Var, oj3 oj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, vx2Var, oj3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + vx2Var + " errCode=" + oj3Var);
            }
            if (c) {
                if (oj3Var == null) {
                    oj3Var = new oj3();
                    oj3Var.k(5L);
                    oj3Var.i(58L);
                    oj3Var.d("route check fail");
                }
                e(vx2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(oj3Var.a()));
            }
        }
    }
}
