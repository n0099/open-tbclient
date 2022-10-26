package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && l33.K().k() == 1 && !d()) {
            rw2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = rw2.p("startup");
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
            m33 M = m33.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            lg2 Q = w.Q();
            if (!(Q instanceof nz3)) {
                return 0L;
            }
            return ((nz3) Q).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            m33 M = m33.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            lg2 Q = w.Q();
            if (!(Q instanceof nz3)) {
                return false;
            }
            return ((nz3) Q).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, jo2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            pa3 pa3Var = new pa3();
            pa3Var.a = fa3.n(aVar.G());
            pa3Var.f = aVar.H();
            pa3Var.c = aVar.T();
            pa3Var.b = "launch";
            pa3Var.e = "realcancel";
            pa3Var.q = String.valueOf(currentTimeMillis - l);
            pa3Var.a("reason", str);
            pa3Var.a("errorList", d44.c().d());
            pa3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            fa3.onEvent(pa3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(jo2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            pa3 pa3Var = new pa3();
            pa3Var.a = fa3.n(aVar.G());
            pa3Var.f = aVar.H();
            pa3Var.c = aVar.T();
            pa3Var.b = "launch";
            pa3Var.e = "realsuccess";
            pa3Var.r = String.valueOf(currentTimeMillis - l);
            pa3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            fa3.onEvent(pa3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
