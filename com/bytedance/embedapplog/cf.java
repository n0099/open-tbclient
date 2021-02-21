package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cf extends ch {
    private final Context e;
    private final cn pmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pmW = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.pmW.J())) {
            jSONObject.put("ab_client", this.pmW.J());
        }
        if (!TextUtils.isEmpty(this.pmW.t())) {
            if (au.f5788b) {
                au.a("init config has abversion:" + this.pmW.t(), null);
            }
            jSONObject.put("ab_version", this.pmW.t());
        }
        if (!TextUtils.isEmpty(this.pmW.K())) {
            jSONObject.put("ab_group", this.pmW.K());
        }
        if (!TextUtils.isEmpty(this.pmW.L())) {
            jSONObject.put("ab_feature", this.pmW.L());
            return true;
        }
        return true;
    }
}
