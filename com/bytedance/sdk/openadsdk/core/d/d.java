package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f27813a;

    /* renamed from: b  reason: collision with root package name */
    public String f27814b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f27815c;

    public void a(String str) {
        this.f27813a = str;
    }

    public void b(String str) {
        this.f27814b = str;
    }

    public void a(Map<String, String> map) {
        this.f27815c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f27813a) && !TextUtils.isEmpty(this.f27814b)) {
            try {
                jSONObject.put("url", this.f27813a);
                jSONObject.put("html", this.f27814b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f27815c != null && this.f27815c.size() > 0) {
                    for (Map.Entry<String, String> entry : this.f27815c.entrySet()) {
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
