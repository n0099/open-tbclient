package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.gp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xa3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948293599, "Lcom/baidu/tieba/xa3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948293599, "Lcom/baidu/tieba/xa3;");
                return;
            }
        }
        a = tk1.a;
        b = false;
        c = false;
        qn2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(ju2 ju2Var, String str, ar1 ar1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ju2Var, str, ar1Var) == null) {
            e(ju2Var, str, ar1Var, null);
        }
    }

    public static void e(ju2 ju2Var, String str, ar1 ar1Var, String str2) {
        j43 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, ju2Var, str, ar1Var, str2) != null) || !d || (b0 = j43.b0()) == null) {
            return;
        }
        gp2.a W = b0.W();
        mb3 mb3Var = new mb3();
        mb3Var.a = cb3.n(W.G());
        mb3Var.f = W.H();
        if (a22.d()) {
            mb3Var.c = "remote-debug";
        } else if (i03.D()) {
            mb3Var.c = "local-debug";
        } else {
            mb3Var.c = W.T();
        }
        mb3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            mb3Var.e = str;
        }
        if (ju2Var != null) {
            mb3Var.a("path", ju2Var.a);
            mb3Var.a("routeType", ju2Var.e);
            mb3Var.a("routeid", ju2Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            mb3Var.a("errcode", str2);
        }
        if (ar1Var != null && ar1Var.c > 0) {
            mb3Var.a("valuetype", ar1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            mb3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        }
        mb3Var.b(cb3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + mb3Var.f());
        }
        cb3.onEvent(mb3Var);
    }

    public static ju2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            s32 V = wp2.U().V();
            ju2 ju2Var = null;
            if (V == null) {
                return null;
            }
            p32 j = V.j((V.k() - i) - 1);
            if (j instanceof r32) {
                ju2Var = ((r32) j).m3();
                ju2Var.e = "1";
                ju2Var.f = str;
            }
            g(ju2Var);
            return ju2Var;
        }
        return (ju2) invokeLI.objValue;
    }

    public static void g(ju2 ju2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, ju2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(ju2Var, null, null);
            }
        }
    }

    public static void h(ju2 ju2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ju2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(ju2Var, null, null);
        }
    }

    public static void i(ju2 ju2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ju2Var) == null) {
            j(ju2Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (xa3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (xa3.class) {
                b = z;
            }
        }
    }

    public static void j(ju2 ju2Var, cg3 cg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, ju2Var, cg3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + ju2Var + " errCode=" + cg3Var);
            }
            if (c) {
                if (cg3Var == null) {
                    cg3Var = new cg3();
                    cg3Var.k(5L);
                    cg3Var.i(58L);
                    cg3Var.d("route check fail");
                }
                e(ju2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(cg3Var.a()));
            }
        }
    }
}
