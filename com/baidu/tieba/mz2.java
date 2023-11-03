package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.dr2;
import com.baidu.tieba.lc2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mz2 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947989892, "Lcom/baidu/tieba/mz2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947989892, "Lcom/baidu/tieba/mz2;");
        }
    }

    public static void a(String str, @Nullable gw2 gw2Var) {
        g63 M;
        dr2.a Z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, str, gw2Var) != null) || (M = g63.M()) == null || (Z = M.Z()) == null) {
            return;
        }
        HybridUbcFlow q = lz2.q("route", str);
        q.D("appid", Z.I());
        q.D("swan", lf3.i(Z.k0(), Z.H()));
        q.D("net", SwanAppNetworkUtils.f().type);
        q.D("appversion", Z.x1());
        q.D("thirdversion", Z.y1());
        q.D("mobile", wi3.c());
        q.D("scheme", Z.X());
        q.D("launchid", Z.W());
        q.E("from", "swan");
        q.D("web_widget_state", "0");
        q.A();
        if (gw2Var != null) {
            q.E("na_multi_jump_dst_path", gw2Var.a());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            tw2.j(true);
            lz2.s("route", str);
            HybridUbcFlow q = lz2.q("route", str);
            q.F(new UbcFlowEvent("na_first_receive_action"));
            q.D("sub_state", "0");
            a = System.currentTimeMillis();
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && TextUtils.equals(lz2.q("route", str).h("sub_state"), "1")) {
            lz2.q("route", str).F(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void c(int i, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            lo2.c(i);
            HybridUbcFlow q = lz2.q("route", str);
            if (i != 6 && i != 4 && i != 1) {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.E("type", Integer.valueOf(i));
            o52 J = tr2.V().J();
            if (J != null) {
                str2 = J.t3().a();
            } else {
                str2 = "";
            }
            q.E("na_multi_jump_src_path", str2);
        }
    }

    public static void e(lc2.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eVar, str) == null) {
            lz2.q("route", str).F(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (eVar == null) {
                return;
            }
            ns1 ns1Var = eVar.a;
            if (ns1Var != null) {
                ns1Var.t(str);
            }
            HybridUbcFlow q = lz2.q("route", str);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_slave_start");
            ubcFlowEvent.h(eVar.d);
            q.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_slave_end");
            ubcFlowEvent2.h(eVar.e);
            q.F(ubcFlowEvent2);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            HybridUbcFlow q = lz2.q("route", str);
            q.F(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.D("web_widget_state", "1");
            q.U();
        }
    }
}
