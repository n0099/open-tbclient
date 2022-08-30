package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class w63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, str) == null) {
            z63.l(true, str);
            JSONObject optJSONObject = jSONObject.optJSONObject("stability_config");
            if (optJSONObject == null) {
                return;
            }
            ay1.b("SwanAppStabilityConfig", "stabilityConfigJo=" + optJSONObject);
            z63.n(str, optJSONObject.optInt("_SwanStartupStability_"));
            z63.k(str, optJSONObject.optInt("obtain_interval_ms", 500));
            int optInt = optJSONObject.optInt("auto_obtain_data_len", 0);
            if (optInt > 0) {
                z63.i(str, true);
                z63.j(str, optInt);
            }
        }
    }

    public static void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            z63.m(true, str);
        }
    }

    public static void c(JSONObject jSONObject, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, str) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("performance_type");
        if (TextUtils.equals(optString, CloudStabilityUBCUtils.VALUE_TYPE)) {
            a(jSONObject, str);
        } else if (TextUtils.equals(optString, "stabilityProfile")) {
            b(str);
        }
    }
}
