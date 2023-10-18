package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && o53.K().k() == 1 && !d()) {
            uy2.p("startup").F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            HybridUbcFlow p = uy2.p("startup");
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
            p53 M = p53.M();
            if (M == null || (w = M.w()) == null) {
                return 0L;
            }
            oi2 Q = w.Q();
            if (!(Q instanceof q14)) {
                return 0L;
            }
            return ((q14) Q).g1();
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            p53 M = p53.M();
            if (M == null || (w = M.w()) == null) {
                return false;
            }
            oi2 Q = w.Q();
            if (!(Q instanceof q14)) {
                return false;
            }
            return ((q14) Q).k1();
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, mq2.a aVar) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) && aVar != null && !d() && (Q = aVar.Q()) != null && Q.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            sc3 sc3Var = new sc3();
            sc3Var.a = ic3.n(aVar.H());
            sc3Var.f = aVar.I();
            sc3Var.c = aVar.U();
            sc3Var.b = "launch";
            sc3Var.e = "realcancel";
            sc3Var.q = String.valueOf(currentTimeMillis - l);
            sc3Var.a("reason", str);
            sc3Var.a("errorList", g64.c().d());
            sc3Var.d(Q.getString("ubc"));
            ic3.onEvent(sc3Var);
            Q.remove("page_display_flag_for_statistic");
        }
    }

    public static void f(mq2.a aVar) {
        Bundle Q;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, aVar) == null) && aVar != null && d() && (Q = aVar.Q()) != null && Q.getLong("page_display_flag_for_statistic") > 0) {
            long l = aVar.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            sc3 sc3Var = new sc3();
            sc3Var.a = ic3.n(aVar.H());
            sc3Var.f = aVar.I();
            sc3Var.c = aVar.U();
            sc3Var.b = "launch";
            sc3Var.e = "realsuccess";
            sc3Var.r = String.valueOf(currentTimeMillis - l);
            sc3Var.d(Q.getString("ubc"));
            ic3.onEvent(sc3Var);
            Q.remove("page_display_flag_for_statistic");
        }
    }
}
