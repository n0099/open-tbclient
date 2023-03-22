package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && s73.K().k() == 1 && !d()) {
            y03.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = y03.p("startup");
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
            t73 M = t73.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            sk2 S = w.S();
            if (!(S instanceof u34)) {
                return 0L;
            }
            return ((u34) S).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            t73 M = t73.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            sk2 S = w.S();
            if (!(S instanceof u34)) {
                return false;
            }
            return ((u34) S).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, qs2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            we3 we3Var = new we3();
            we3Var.a = me3.n(aVar.G());
            we3Var.f = aVar.H();
            we3Var.c = aVar.T();
            we3Var.b = "launch";
            we3Var.e = "realcancel";
            we3Var.q = String.valueOf(currentTimeMillis - l);
            we3Var.a("reason", str);
            we3Var.a("errorList", k84.c().d());
            we3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            me3.onEvent(we3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(qs2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            we3 we3Var = new we3();
            we3Var.a = me3.n(aVar.G());
            we3Var.f = aVar.H();
            we3Var.c = aVar.T();
            we3Var.b = "launch";
            we3Var.e = "realsuccess";
            we3Var.r = String.valueOf(currentTimeMillis - l);
            we3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            me3.onEvent(we3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
