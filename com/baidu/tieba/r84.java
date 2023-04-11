package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && t73.K().k() == 1 && !d()) {
            z03.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = z03.p("startup");
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
            u73 M = u73.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            tk2 S = w.S();
            if (!(S instanceof v34)) {
                return 0L;
            }
            return ((v34) S).f1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            u73 M = u73.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            tk2 S = w.S();
            if (!(S instanceof v34)) {
                return false;
            }
            return ((v34) S).j1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, rs2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            xe3 xe3Var = new xe3();
            xe3Var.a = ne3.n(aVar.G());
            xe3Var.f = aVar.H();
            xe3Var.c = aVar.T();
            xe3Var.b = "launch";
            xe3Var.e = "realcancel";
            xe3Var.q = String.valueOf(currentTimeMillis - l);
            xe3Var.a("reason", str);
            xe3Var.a("errorList", l84.c().d());
            xe3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            ne3.onEvent(xe3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(rs2.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (P = aVar.P()) != null && P.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            xe3 xe3Var = new xe3();
            xe3Var.a = ne3.n(aVar.G());
            xe3Var.f = aVar.H();
            xe3Var.c = aVar.T();
            xe3Var.b = "launch";
            xe3Var.e = "realsuccess";
            xe3Var.r = String.valueOf(currentTimeMillis - l);
            xe3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            ne3.onEvent(xe3Var);
            P.remove("page_display_flag_for_statistic");
        }
    }
}
