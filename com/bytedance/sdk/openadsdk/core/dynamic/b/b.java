package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.bytedance.sdk.openadsdk.core.p;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private List<String> b() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : b()) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
            jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
            jSONObject.put("aid", com.bytedance.sdk.openadsdk.a.a.b());
            jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
            jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.a.a.d());
            jSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
            jSONObject.put("supportList", jSONArray);
            jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(p.a()));
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
