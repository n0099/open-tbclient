package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && w73.K().k() == 1 && !d()) {
            c13.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = c13.p("startup");
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
            x73 M = x73.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            wk2 S = w.S();
            if (!(S instanceof y34)) {
                return 0L;
            }
            return ((y34) S).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            x73 M = x73.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            wk2 S = w.S();
            if (!(S instanceof y34)) {
                return false;
            }
            return ((y34) S).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, us2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            af3 af3Var = new af3();
            af3Var.a = qe3.n(aVar.G());
            af3Var.f = aVar.H();
            af3Var.c = aVar.T();
            af3Var.b = "launch";
            af3Var.e = "realcancel";
            af3Var.q = String.valueOf(currentTimeMillis - l);
            af3Var.a("reason", str);
            af3Var.a("errorList", o84.c().d());
            af3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            qe3.onEvent(af3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(us2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            af3 af3Var = new af3();
            af3Var.a = qe3.n(aVar.G());
            af3Var.f = aVar.H();
            af3Var.c = aVar.T();
            af3Var.b = "launch";
            af3Var.e = "realsuccess";
            af3Var.r = String.valueOf(currentTimeMillis - l);
            af3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            qe3.onEvent(af3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
