package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cf extends ch {
    private final Context e;
    private final cn pmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pmw = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.pmw.J())) {
            jSONObject.put("ab_client", this.pmw.J());
        }
        if (!TextUtils.isEmpty(this.pmw.t())) {
            if (au.f5788b) {
                au.a("init config has abversion:" + this.pmw.t(), null);
            }
            jSONObject.put("ab_version", this.pmw.t());
        }
        if (!TextUtils.isEmpty(this.pmw.K())) {
            jSONObject.put("ab_group", this.pmw.K());
        }
        if (!TextUtils.isEmpty(this.pmw.L())) {
            jSONObject.put("ab_feature", this.pmw.L());
            return true;
        }
        return true;
    }
}
