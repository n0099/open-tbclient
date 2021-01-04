package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f6788a;

    /* renamed from: b  reason: collision with root package name */
    private String f6789b;
    private Map<String, String> c;

    public void a(String str) {
        this.f6788a = str;
    }

    public void b(String str) {
        this.f6789b = str;
    }

    public void a(Map<String, String> map) {
        this.c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(this.f6788a) || TextUtils.isEmpty(this.f6789b)) {
            return jSONObject;
        }
        try {
            jSONObject.put("url", this.f6788a);
            jSONObject.put("html", this.f6789b);
            JSONObject jSONObject2 = new JSONObject();
            if (this.c != null && this.c.size() > 0) {
                for (Map.Entry<String, String> entry : this.c.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("headers", jSONObject2);
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
