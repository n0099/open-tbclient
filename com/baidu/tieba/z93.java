package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class z93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948314741, "Lcom/baidu/tieba/z93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948314741, "Lcom/baidu/tieba/z93;");
                return;
            }
        }
        a = vj1.a;
        b = false;
        c = false;
        sm2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(lt2 lt2Var, String str, cq1 cq1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, lt2Var, str, cq1Var) == null) {
            e(lt2Var, str, cq1Var, null);
        }
    }

    public static void e(lt2 lt2Var, String str, cq1 cq1Var, String str2) {
        l33 b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65541, null, lt2Var, str, cq1Var, str2) == null) && d && (b0 = l33.b0()) != null) {
            io2.a W = b0.W();
            oa3 oa3Var = new oa3();
            oa3Var.a = ea3.n(W.G());
            oa3Var.f = W.H();
            if (c12.d()) {
                oa3Var.c = "remote-debug";
            } else if (kz2.D()) {
                oa3Var.c = "local-debug";
            } else {
                oa3Var.c = W.T();
            }
            oa3Var.b = "pageshow";
            if (!TextUtils.isEmpty(str)) {
                oa3Var.e = str;
            }
            if (lt2Var != null) {
                oa3Var.a("path", lt2Var.a);
                oa3Var.a("routeType", lt2Var.e);
                oa3Var.a("routeid", lt2Var.f);
            }
            if (!TextUtils.isEmpty(str2)) {
                oa3Var.a("errcode", str2);
            }
            if (cq1Var != null && cq1Var.c > 0) {
                oa3Var.a("valuetype", cq1Var.g);
            }
            Bundle P = W.P();
            if (P != null) {
                oa3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            oa3Var.b(ea3.k(W.W()));
            if (a) {
                Log.d("SwanAppRouteUbc", "onRouteEvent - " + oa3Var.f());
            }
            ea3.onEvent(oa3Var);
        }
    }

    public static lt2 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            u22 V = yo2.U().V();
            lt2 lt2Var = null;
            if (V == null) {
                return null;
            }
            r22 j = V.j((V.k() - i) - 1);
            if (j instanceof t22) {
                lt2Var = ((t22) j).m3();
                lt2Var.e = "1";
                lt2Var.f = str;
            }
            g(lt2Var);
            return lt2Var;
        }
        return (lt2) invokeLI.objValue;
    }

    public static void g(lt2 lt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, lt2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (c()) {
                return;
            }
            k(true);
            d(lt2Var, null, null);
        }
    }

    public static void h(lt2 lt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, lt2Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(lt2Var, null, null);
        }
    }

    public static void i(lt2 lt2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, lt2Var) == null) {
            j(lt2Var, null);
        }
    }

    public static void j(lt2 lt2Var, ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, lt2Var, ef3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + lt2Var + " errCode=" + ef3Var);
            }
            if (c) {
                if (ef3Var == null) {
                    ef3Var = new ef3();
                    ef3Var.k(5L);
                    ef3Var.i(58L);
                    ef3Var.d("route check fail");
                }
                e(lt2Var, com.baidu.pass.biometrics.face.liveness.b.a.g0, null, String.valueOf(ef3Var.a()));
            }
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (z93.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (z93.class) {
                b = z;
            }
        }
    }
}
