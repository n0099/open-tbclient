package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f27901a;

    /* renamed from: b  reason: collision with root package name */
    public String f27902b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f27903c;

    public void a(String str) {
        this.f27901a = str;
    }

    public void b(String str) {
        this.f27902b = str;
    }

    public void a(Map<String, String> map) {
        this.f27903c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f27901a) && !TextUtils.isEmpty(this.f27902b)) {
            try {
                jSONObject.put("url", this.f27901a);
                jSONObject.put("html", this.f27902b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f27903c != null && this.f27903c.size() > 0) {
                    for (Map.Entry<String, String> entry : this.f27903c.entrySet()) {
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
