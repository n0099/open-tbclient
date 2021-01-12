package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cf extends ch {
    private final Context e;
    private final cn pcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pcg = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.pcg.J())) {
            jSONObject.put("ab_client", this.pcg.J());
        }
        if (!TextUtils.isEmpty(this.pcg.t())) {
            if (au.f5786b) {
                au.a("init config has abversion:" + this.pcg.t(), null);
            }
            jSONObject.put("ab_version", this.pcg.t());
        }
        if (!TextUtils.isEmpty(this.pcg.K())) {
            jSONObject.put("ab_group", this.pcg.K());
        }
        if (!TextUtils.isEmpty(this.pcg.L())) {
            jSONObject.put("ab_feature", this.pcg.L());
            return true;
        }
        return true;
    }
}
