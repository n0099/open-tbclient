package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cm extends ch {
    private final Context e;
    private final cn ppe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.ppe = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        jSONObject.put(SapiContext.KEY_SDK_VERSION, 336);
        jSONObject.put(HttpConstants.SDK_VERSION_NAME, "3.6.0-rc.9-embed");
        jSONObject.put("channel", this.ppe.k());
        m.a(jSONObject, "aid", this.ppe.j());
        m.a(jSONObject, "release_build", this.ppe.A());
        m.a(jSONObject, "app_region", this.ppe.n());
        m.a(jSONObject, "app_language", this.ppe.m());
        m.a(jSONObject, "user_agent", this.ppe.B());
        m.a(jSONObject, "ab_sdk_version", this.ppe.p());
        m.a(jSONObject, "ab_version", this.ppe.t());
        m.a(jSONObject, "aliyun_uuid", this.ppe.a());
        String l = this.ppe.l();
        if (TextUtils.isEmpty(l)) {
            l = aq.a(this.e, this.ppe);
        }
        if (!TextUtils.isEmpty(l)) {
            m.a(jSONObject, "google_aid", l);
        }
        String z = this.ppe.z();
        if (!TextUtils.isEmpty(z)) {
            try {
                jSONObject.put("app_track", new JSONObject(z));
            } catch (Throwable th) {
                au.a(th);
            }
        }
        String o = this.ppe.o();
        if (o != null && o.length() > 0) {
            jSONObject.put("custom", new JSONObject(o));
        }
        m.a(jSONObject, "user_unique_id", this.ppe.q());
        return true;
    }
}
