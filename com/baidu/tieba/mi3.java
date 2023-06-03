package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mi3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947973586, "Lcom/baidu/tieba/mi3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947973586, "Lcom/baidu/tieba/mi3;");
                return;
            }
        }
        a = is1.a;
        b = false;
        c = false;
        fv2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(y13 y13Var, String str, py1 py1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, y13Var, str, py1Var) == null) {
            e(y13Var, str, py1Var, null);
        }
    }

    public static void e(y13 y13Var, String str, py1 py1Var, String str2) {
        yb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, y13Var, str, py1Var, str2) != null) || !d || (b0 = yb3.b0()) == null) {
            return;
        }
        vw2.a W = b0.W();
        bj3 bj3Var = new bj3();
        bj3Var.a = ri3.n(W.G());
        bj3Var.f = W.H();
        if (p92.d()) {
            bj3Var.c = "remote-debug";
        } else if (x73.D()) {
            bj3Var.c = "local-debug";
        } else {
            bj3Var.c = W.T();
        }
        bj3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            bj3Var.e = str;
        }
        if (y13Var != null) {
            bj3Var.a("path", y13Var.a);
            bj3Var.a("routeType", y13Var.e);
            bj3Var.a("routeid", y13Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            bj3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (py1Var != null && py1Var.c > 0) {
            bj3Var.a("valuetype", py1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            bj3Var.d(P.getString("ubc"));
        }
        bj3Var.b(ri3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + bj3Var.f());
        }
        ri3.onEvent(bj3Var);
    }

    public static y13 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            hb2 U = lx2.T().U();
            y13 y13Var = null;
            if (U == null) {
                return null;
            }
            eb2 j = U.j((U.k() - i) - 1);
            if (j instanceof gb2) {
                y13Var = ((gb2) j).o3();
                y13Var.e = "1";
                y13Var.f = str;
            }
            g(y13Var);
            return y13Var;
        }
        return (y13) invokeLI.objValue;
    }

    public static void g(y13 y13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, y13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(y13Var, null, null);
            }
        }
    }

    public static void h(y13 y13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, y13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(y13Var, null, null);
        }
    }

    public static void i(y13 y13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, y13Var) == null) {
            j(y13Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (mi3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (mi3.class) {
                b = z;
            }
        }
    }

    public static void j(y13 y13Var, rn3 rn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, y13Var, rn3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + y13Var + " errCode=" + rn3Var);
            }
            if (c) {
                if (rn3Var == null) {
                    rn3Var = new rn3();
                    rn3Var.k(5L);
                    rn3Var.i(58L);
                    rn3Var.d("route check fail");
                }
                e(y13Var, "fail", null, String.valueOf(rn3Var.a()));
            }
        }
    }
}
