package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && xa3.K().k() == 1 && !d()) {
            d43.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = d43.p("startup");
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
            ya3 M = ya3.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            xn2 R = w.R();
            if (!(R instanceof z64)) {
                return 0L;
            }
            return ((z64) R).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ya3 M = ya3.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            xn2 R = w.R();
            if (!(R instanceof z64)) {
                return false;
            }
            return ((z64) R).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, vv2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            bi3 bi3Var = new bi3();
            bi3Var.a = rh3.n(aVar.G());
            bi3Var.f = aVar.H();
            bi3Var.c = aVar.T();
            bi3Var.b = "launch";
            bi3Var.e = "realcancel";
            bi3Var.q = String.valueOf(currentTimeMillis - l);
            bi3Var.a("reason", str);
            bi3Var.a("errorList", pb4.c().d());
            bi3Var.d(P.getString("ubc"));
            rh3.onEvent(bi3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(vv2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            bi3 bi3Var = new bi3();
            bi3Var.a = rh3.n(aVar.G());
            bi3Var.f = aVar.H();
            bi3Var.c = aVar.T();
            bi3Var.b = "launch";
            bi3Var.e = "realsuccess";
            bi3Var.r = String.valueOf(currentTimeMillis - l);
            bi3Var.d(P.getString("ubc"));
            rh3.onEvent(bi3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
