package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947985118, "Lcom/baidu/tieba/o73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947985118, "Lcom/baidu/tieba/o73;");
                return;
            }
        }
        a = kh1.a;
        b = false;
        c = false;
        hk2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(ar2 ar2Var, String str, rn1 rn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ar2Var, str, rn1Var) == null) {
            e(ar2Var, str, rn1Var, null);
        }
    }

    public static void e(ar2 ar2Var, String str, rn1 rn1Var, String str2) {
        a13 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, ar2Var, str, rn1Var, str2) == null) && d && (b0 = a13.b0()) != null) {
            xl2.a W = b0.W();
            d83 d83Var = new d83();
            d83Var.a = t73.n(W.G());
            d83Var.f = W.H();
            if (ry1.d()) {
                d83Var.c = "remote-debug";
            } else if (zw2.D()) {
                d83Var.c = "local-debug";
            } else {
                d83Var.c = W.T();
            }
            d83Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                d83Var.e = str;
            }
            if (ar2Var != null) {
                d83Var.a("path", ar2Var.a);
                d83Var.a("routeType", ar2Var.e);
                d83Var.a("routeid", ar2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                d83Var.a("errcode", str2);
            }
            if (rn1Var != null && rn1Var.c > 0) {
                d83Var.a("valuetype", rn1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                d83Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            d83Var.b(t73.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + d83Var.f());
            }
            t73.onEvent(d83Var);
        }
    }

    public static ar2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            j02 V = nm2.U().V();
            ar2 ar2Var = null;
            if (V == null) {
                return null;
            }
            g02 j = V.j((V.k() - i) - 1);
            if (j instanceof i02) {
                ar2Var = ((i02) j).m3();
                ar2Var.e = "1";
                ar2Var.f = str;
            }
            g(ar2Var);
            return ar2Var;
        }
        return (ar2) invokeLI.objValue;
    }

    public static void g(ar2 ar2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, ar2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(ar2Var, null, null);
        }
    }

    public static void h(ar2 ar2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, ar2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(ar2Var, null, null);
        }
    }

    public static void i(ar2 ar2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ar2Var) == null) {
            j(ar2Var, null);
        }
    }

    public static void j(ar2 ar2Var, tc3 tc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, ar2Var, tc3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + ar2Var + " errCode=" + tc3Var);
            }
            if (c) {
                if (tc3Var == null) {
                    tc3Var = new tc3();
                    tc3Var.k(5L);
                    tc3Var.i(58L);
                    tc3Var.d("route check fail");
                }
                e(ar2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(tc3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (o73.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (o73.class) {
                b = z;
            }
        }
    }
}
