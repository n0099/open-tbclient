package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f27830a;

    /* renamed from: b  reason: collision with root package name */
    public String f27831b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f27832c;

    public void a(String str) {
        this.f27830a = str;
    }

    public void b(String str) {
        this.f27831b = str;
    }

    public void a(Map<String, String> map) {
        this.f27832c = map;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f27830a) && !TextUtils.isEmpty(this.f27831b)) {
            try {
                jSONObject.put("url", this.f27830a);
                jSONObject.put("html", this.f27831b);
                JSONObject jSONObject2 = new JSONObject();
                if (this.f27832c != null && this.f27832c.size() > 0) {
                    for (Map.Entry<String, String> entry : this.f27832c.entrySet()) {
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
