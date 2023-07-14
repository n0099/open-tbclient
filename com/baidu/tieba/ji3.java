package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ji3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947884213, "Lcom/baidu/tieba/ji3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947884213, "Lcom/baidu/tieba/ji3;");
                return;
            }
        }
        a = fs1.a;
        b = false;
        c = false;
        cv2.g0().getSwitch("swan_app_use_route_statistic", false);
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

    public static void d(v13 v13Var, String str, my1 my1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, v13Var, str, my1Var) == null) {
            e(v13Var, str, my1Var, null);
        }
    }

    public static void e(v13 v13Var, String str, my1 my1Var, String str2) {
        vb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65541, null, v13Var, str, my1Var, str2) != null) || !d || (b0 = vb3.b0()) == null) {
            return;
        }
        sw2.a W = b0.W();
        yi3 yi3Var = new yi3();
        yi3Var.a = oi3.n(W.G());
        yi3Var.f = W.H();
        if (m92.d()) {
            yi3Var.c = "remote-debug";
        } else if (u73.D()) {
            yi3Var.c = "local-debug";
        } else {
            yi3Var.c = W.T();
        }
        yi3Var.b = "pageshow";
        if (!TextUtils.isEmpty(str)) {
            yi3Var.e = str;
        }
        if (v13Var != null) {
            yi3Var.a("path", v13Var.a);
            yi3Var.a("routeType", v13Var.e);
            yi3Var.a("routeid", v13Var.f);
        }
        if (!TextUtils.isEmpty(str2)) {
            yi3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, str2);
        }
        if (my1Var != null && my1Var.c > 0) {
            yi3Var.a("valuetype", my1Var.g);
        }
        Bundle P = W.P();
        if (P != null) {
            yi3Var.d(P.getString("ubc"));
        }
        yi3Var.b(oi3.k(W.W()));
        if (a) {
            Log.d("SwanAppRouteUbc", "onRouteEvent - " + yi3Var.f());
        }
        oi3.onEvent(yi3Var);
    }

    public static v13 f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            eb2 U = ix2.T().U();
            v13 v13Var = null;
            if (U == null) {
                return null;
            }
            bb2 j = U.j((U.k() - i) - 1);
            if (j instanceof db2) {
                v13Var = ((db2) j).o3();
                v13Var.e = "1";
                v13Var.f = str;
            }
            g(v13Var);
            return v13Var;
        }
        return (v13) invokeLI.objValue;
    }

    public static void g(v13 v13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, v13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByApi");
            }
            if (!c()) {
                k(true);
                d(v13Var, null, null);
            }
        }
    }

    public static void h(v13 v13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, v13Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteAllByResume");
            }
            d(v13Var, null, null);
        }
    }

    public static void i(v13 v13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, v13Var) == null) {
            j(v13Var, null);
        }
    }

    public static synchronized void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            synchronized (ji3.class) {
                c = z;
            }
        }
    }

    public static synchronized void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            synchronized (ji3.class) {
                b = z;
            }
        }
    }

    public static void j(v13 v13Var, on3 on3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, v13Var, on3Var) == null) {
            if (a) {
                Log.d("SwanAppRouteUbc", "recordRouteFailByApi - pageParam=" + v13Var + " errCode=" + on3Var);
            }
            if (c) {
                if (on3Var == null) {
                    on3Var = new on3();
                    on3Var.k(5L);
                    on3Var.i(58L);
                    on3Var.d("route check fail");
                }
                e(v13Var, "fail", null, String.valueOf(on3Var.a()));
            }
        }
    }
}
