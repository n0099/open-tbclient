package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f28656a;

    /* renamed from: b  reason: collision with root package name */
    public String f28657b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f28658c;

    public void a(String str) {
        this.f28656a = str;
    }

    public void b(String str) {
        this.f28657b = str;
    }

    public void a(Map<String, String> map) {
        this.f28658c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f28656a) && !TextUtils.isEmpty(this.f28657b)) {
            try {
                jSONObject.put("url", this.f28656a);
                jSONObject.put("html", this.f28657b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f28658c != null && this.f28658c.size() > 0) {
                    for (Map.Entry<String, String> entry : this.f28658c.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("headers", jSONObject2);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
