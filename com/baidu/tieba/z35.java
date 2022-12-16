package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class z35 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static Map<String, String> b;
    public static boolean c;
    public static boolean d;
    public static int e;
    public static int f;
    public static boolean g;
    public static String h;
    public static Map<String, String> i;
    public static int j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948309037, "Lcom/baidu/tieba/z35;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948309037, "Lcom/baidu/tieba/z35;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!c) {
                return ry4.l().m("video_report_config_upload_number", 5);
            }
            return f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!c) {
                return ry4.l().m("video_report_config_upload_type", 0);
            }
            return e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!c) {
                return ry4.l().i("video_report_config_switch", true);
            }
            return d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) != null) || jSONObject == null) {
            return;
        }
        boolean z3 = true;
        c = true;
        if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) == 0) {
            z = false;
        } else {
            z = true;
        }
        d = z;
        ry4.l().v("video_report_config_switch", d);
        e = jSONObject.optInt("upload_type", 0);
        ry4.l().x("video_report_config_upload_type", e);
        f = jSONObject.optInt("upload_number", 5);
        ry4.l().x("video_report_config_upload_number", f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        ry4.l().x("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        ry4.l().x("video_report_prepare_max_loading_time", k);
        if (jSONObject.optInt("is_open_prepare_time", 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        l = z2;
        ry4.l().v("video_report_is_open_prepare_time", l);
        if (jSONObject.optInt("moov_check", 0) == 0) {
            z3 = false;
        }
        g = z3;
        ry4.l().v("video_report_config_moov_check", g);
        String optString = jSONObject.optString("android_debug_type");
        h = optString;
        if (!StringUtils.isNull(optString)) {
            ry4.l().z("video_report_config_debug_type", h);
            e(h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        a = optString2;
        if (!StringUtils.isNull(optString2)) {
            ry4.l().z("video_report_config_step_cache_strategy", a);
            f(a);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (i == null) {
            i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        if (b == null) {
            b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
