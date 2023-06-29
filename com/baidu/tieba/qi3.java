package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qi3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948092750, "Lcom/baidu/tieba/qi3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948092750, "Lcom/baidu/tieba/qi3;");
                return;
            }
        }
        a = ms1.a;
        b = false;
        c = false;
        jv2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(c23 c23Var, String str, ty1 ty1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, c23Var, str, ty1Var) == null) {
            e(c23Var, str, ty1Var, null);
        }
    }

    public static void e(c23 c23Var, String str, ty1 ty1Var, String str2) {
        cc3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, c23Var, str, ty1Var, str2) != null) || !d || (b0 = cc3.b0()) == null) {
            return;
        }
        zw2.a W = b0.W();
        fj3 fj3Var = new fj3();
        fj3Var.a = vi3.n(W.G());
        fj3Var.f = W.H();
        if (t92.d()) {
            fj3Var.c = "remote-debug";
        } else if (b83.D()) {
            fj3Var.c = "local-debug";
        } else {
            fj3Var.c = W.T();
        }
        fj3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            fj3Var.e = str;
        }
        if (c23Var != null) {
            fj3Var.a("path", c23Var.a);
            fj3Var.a("routeType", c23Var.e);
            fj3Var.a("routeid", c23Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            fj3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (ty1Var != null && ty1Var.c > 0) {
            fj3Var.a("valuetype", ty1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            fj3Var.d(P.getString("ubc"));
        }
        fj3Var.b(vi3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + fj3Var.f());
        }
        vi3.onEvent(fj3Var);
    }

    public static c23 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            lb2 U = px2.T().U();
            c23 c23Var = null;
            if (U == null) {
                return null;
            }
            ib2 j = U.j((U.k() - i) - 1);
            if (j instanceof kb2) {
                c23Var = ((kb2) j).o3();
                c23Var.e = "1";
                c23Var.f = str;
            }
            g(c23Var);
            return c23Var;
        }
        return (c23) invokeLI.objValue;
    }

    public static void g(c23 c23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, c23Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(c23Var, null, null);
            }
        }
    }

    public static void h(c23 c23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, c23Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(c23Var, null, null);
        }
    }

    public static void i(c23 c23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, c23Var) == null) {
            j(c23Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (qi3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (qi3.class) {
                b = z;
            }
        }
    }

    public static void j(c23 c23Var, vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, c23Var, vn3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + c23Var + " errCode=" + vn3Var);
            }
            if (c) {
                if (vn3Var == null) {
                    vn3Var = new vn3();
                    vn3Var.k(5L);
                    vn3Var.i(58L);
                    vn3Var.d("route check fail");
                }
                e(c23Var, "fail", null, String.valueOf(vn3Var.a()));
            }
        }
    }
}
