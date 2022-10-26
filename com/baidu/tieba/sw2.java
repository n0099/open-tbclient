package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.jo2;
import com.baidu.tieba.r92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sw2 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948165755, "Lcom/baidu/tieba/sw2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948165755, "Lcom/baidu/tieba/sw2;");
        }
    }

    public static void a(String str, mt2 mt2Var) {
        m33 M;
        jo2.a Y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, str, mt2Var) != null) || (M = m33.M()) == null || (Y = M.Y()) == null) {
            return;
        }
        HybridUbcFlow q = rw2.q("route", str);
        q.D("appid", Y.H());
        q.D("swan", rc3.i(Y.j0(), Y.G()));
        q.D("net", SwanAppNetworkUtils.f().type);
        q.D("appversion", Y.v1());
        q.D("thirdversion", Y.w1());
        q.D("mobile", cg3.c());
        q.D("scheme", Y.W());
        q.D("launchid", Y.V());
        q.E("from", "swan");
        q.D("web_widget_state", "0");
        q.A();
        if (mt2Var != null) {
            q.E("na_multi_jump_dst_path", mt2Var.a());
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            zt2.j(true);
            rw2.s("route", str);
            HybridUbcFlow q = rw2.q("route", str);
            q.F(new UbcFlowEvent("na_first_receive_action"));
            q.D("sub_state", "0");
            a = System.currentTimeMillis();
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && TextUtils.equals(rw2.q("route", str).h("sub_state"), "1")) {
            rw2.q("route", str).F(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void c(int i, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) {
            rl2.c(i);
            HybridUbcFlow q = rw2.q("route", str);
            if (i != 6 && i != 4 && i != 1) {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE);
            } else {
                q.I(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
            }
            q.E("type", Integer.valueOf(i));
            u22 H = zo2.U().H();
            if (H != null) {
                str2 = H.m3().a();
            } else {
                str2 = "";
            }
            q.E("na_multi_jump_src_path", str2);
        }
    }

    public static void e(r92.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eVar, str) == null) {
            rw2.q("route", str).F(new UbcFlowEvent("na_pre_load_slave_ok"));
            if (eVar == null) {
                return;
            }
            sp1 sp1Var = eVar.a;
            if (sp1Var != null) {
                sp1Var.v(str);
            }
            HybridUbcFlow q = rw2.q("route", str);
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
            HybridUbcFlow q = rw2.q("route", str);
            q.F(new UbcFlowEvent("web_widget_first_screen_finish"));
            q.D("web_widget_state", "1");
            q.T();
        }
    }
}
