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
    private final cn pmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.pmw = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        jSONObject.put(SapiContext.KEY_SDK_VERSION, 336);
        jSONObject.put(HttpConstants.SDK_VERSION_NAME, "3.6.0-rc.5-embed");
        jSONObject.put("channel", this.pmw.k());
        m.a(jSONObject, "aid", this.pmw.j());
        m.a(jSONObject, "release_build", this.pmw.A());
        m.a(jSONObject, "app_region", this.pmw.n());
        m.a(jSONObject, "app_language", this.pmw.m());
        m.a(jSONObject, "user_agent", this.pmw.B());
        m.a(jSONObject, "ab_sdk_version", this.pmw.p());
        m.a(jSONObject, "ab_version", this.pmw.t());
        m.a(jSONObject, "aliyun_uuid", this.pmw.a());
        String l = this.pmw.l();
        if (TextUtils.isEmpty(l)) {
            l = aq.a(this.e, this.pmw);
        }
        if (!TextUtils.isEmpty(l)) {
            m.a(jSONObject, "google_aid", l);
        }
        String z = this.pmw.z();
        if (!TextUtils.isEmpty(z)) {
            try {
                jSONObject.put("app_track", new JSONObject(z));
            } catch (Throwable th) {
                au.a(th);
            }
        }
        String o = this.pmw.o();
        if (o != null && o.length() > 0) {
            jSONObject.put("custom", new JSONObject(o));
        }
        m.a(jSONObject, "user_unique_id", this.pmw.q());
        return true;
    }
}
