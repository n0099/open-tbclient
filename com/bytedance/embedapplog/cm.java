package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cm extends ch {
    private final Context e;
    private final cn pcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.pcg = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        jSONObject.put(SapiContext.KEY_SDK_VERSION, 336);
        jSONObject.put(HttpConstants.SDK_VERSION_NAME, "3.6.0-rc.5-embed");
        jSONObject.put("channel", this.pcg.k());
        m.a(jSONObject, "aid", this.pcg.j());
        m.a(jSONObject, "release_build", this.pcg.A());
        m.a(jSONObject, "app_region", this.pcg.n());
        m.a(jSONObject, "app_language", this.pcg.m());
        m.a(jSONObject, "user_agent", this.pcg.B());
        m.a(jSONObject, "ab_sdk_version", this.pcg.p());
        m.a(jSONObject, "ab_version", this.pcg.t());
        m.a(jSONObject, "aliyun_uuid", this.pcg.a());
        String l = this.pcg.l();
        if (TextUtils.isEmpty(l)) {
            l = aq.a(this.e, this.pcg);
        }
        if (!TextUtils.isEmpty(l)) {
            m.a(jSONObject, "google_aid", l);
        }
        String z = this.pcg.z();
        if (!TextUtils.isEmpty(z)) {
            try {
                jSONObject.put("app_track", new JSONObject(z));
            } catch (Throwable th) {
                au.a(th);
            }
        }
        String o = this.pcg.o();
        if (o != null && o.length() > 0) {
            jSONObject.put("custom", new JSONObject(o));
        }
        m.a(jSONObject, "user_unique_id", this.pcg.q());
        return true;
    }
}
