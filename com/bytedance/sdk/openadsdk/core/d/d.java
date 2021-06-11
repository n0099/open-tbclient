package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f27933a;

    /* renamed from: b  reason: collision with root package name */
    public String f27934b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f27935c;

    public void a(String str) {
        this.f27933a = str;
    }

    public void b(String str) {
        this.f27934b = str;
    }

    public void a(Map<String, String> map) {
        this.f27935c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f27933a) && !TextUtils.isEmpty(this.f27934b)) {
            try {
                jSONObject.put("url", this.f27933a);
                jSONObject.put("html", this.f27934b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f27935c != null && this.f27935c.size() > 0) {
                    for (Map.Entry<String, String> entry : this.f27935c.entrySet()) {
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
