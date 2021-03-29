package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f28120a;

    /* renamed from: b  reason: collision with root package name */
    public String f28121b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f28122c;

    public void a(String str) {
        this.f28120a = str;
    }

    public void b(String str) {
        this.f28121b = str;
    }

    public void a(Map<String, String> map) {
        this.f28122c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f28120a) && !TextUtils.isEmpty(this.f28121b)) {
            try {
                jSONObject.put("url", this.f28120a);
                jSONObject.put("html", this.f28121b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f28122c != null && this.f28122c.size() > 0) {
                    for (Map.Entry<String, String> entry : this.f28122c.entrySet()) {
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
