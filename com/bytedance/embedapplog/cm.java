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
    private final cn pch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.pch = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        jSONObject.put(SapiContext.KEY_SDK_VERSION, 336);
        jSONObject.put(HttpConstants.SDK_VERSION_NAME, "3.6.0-rc.5-embed");
        jSONObject.put("channel", this.pch.k());
        m.a(jSONObject, "aid", this.pch.j());
        m.a(jSONObject, "release_build", this.pch.A());
        m.a(jSONObject, "app_region", this.pch.n());
        m.a(jSONObject, "app_language", this.pch.m());
        m.a(jSONObject, "user_agent", this.pch.B());
        m.a(jSONObject, "ab_sdk_version", this.pch.p());
        m.a(jSONObject, "ab_version", this.pch.t());
        m.a(jSONObject, "aliyun_uuid", this.pch.a());
        String l = this.pch.l();
        if (TextUtils.isEmpty(l)) {
            l = aq.a(this.e, this.pch);
        }
        if (!TextUtils.isEmpty(l)) {
            m.a(jSONObject, "google_aid", l);
        }
        String z = this.pch.z();
        if (!TextUtils.isEmpty(z)) {
            try {
                jSONObject.put("app_track", new JSONObject(z));
            } catch (Throwable th) {
                au.a(th);
            }
        }
        String o = this.pch.o();
        if (o != null && o.length() > 0) {
            jSONObject.put("custom", new JSONObject(o));
        }
        m.a(jSONObject, "user_unique_id", this.pch.q());
        return true;
    }
}
