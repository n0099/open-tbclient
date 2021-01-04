package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cf extends ch {
    private final Context e;
    private final cn pgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pgJ = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.pgJ.J())) {
            jSONObject.put("ab_client", this.pgJ.J());
        }
        if (!TextUtils.isEmpty(this.pgJ.t())) {
            if (au.f6085b) {
                au.a("init config has abversion:" + this.pgJ.t(), null);
            }
            jSONObject.put("ab_version", this.pgJ.t());
        }
        if (!TextUtils.isEmpty(this.pgJ.K())) {
            jSONObject.put("ab_group", this.pgJ.K());
        }
        if (!TextUtils.isEmpty(this.pgJ.L())) {
            jSONObject.put("ab_feature", this.pgJ.L());
            return true;
        }
        return true;
    }
}
