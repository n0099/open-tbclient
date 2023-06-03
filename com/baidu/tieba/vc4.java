package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && xb3.K().k() == 1 && !d()) {
            d53.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = d53.p("startup");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("id");
                    long optLong = optJSONObject.optLong("timestamp");
                    if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        ubcFlowEvent.h(optLong);
                        p.F(ubcFlowEvent);
                    }
                }
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            yb3 M = yb3.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            xo2 R = w.R();
            if (!(R instanceof z74)) {
                return 0L;
            }
            return ((z74) R).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            yb3 M = yb3.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            xo2 R = w.R();
            if (!(R instanceof z74)) {
                return false;
            }
            return ((z74) R).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, vw2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            bj3 bj3Var = new bj3();
            bj3Var.a = ri3.n(aVar.G());
            bj3Var.f = aVar.H();
            bj3Var.c = aVar.T();
            bj3Var.b = "launch";
            bj3Var.e = "realcancel";
            bj3Var.q = String.valueOf(currentTimeMillis - l);
            bj3Var.a("reason", str);
            bj3Var.a("errorList", pc4.c().d());
            bj3Var.d(P.getString("ubc"));
            ri3.onEvent(bj3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(vw2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            bj3 bj3Var = new bj3();
            bj3Var.a = ri3.n(aVar.G());
            bj3Var.f = aVar.H();
            bj3Var.c = aVar.T();
            bj3Var.b = "launch";
            bj3Var.e = "realsuccess";
            bj3Var.r = String.valueOf(currentTimeMillis - l);
            bj3Var.d(P.getString("ubc"));
            ri3.onEvent(bj3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
