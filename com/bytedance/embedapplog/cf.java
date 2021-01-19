package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class cf extends ch {
    private final Context e;
    private final cn pch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pch = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.pch.J())) {
            jSONObject.put("ab_client", this.pch.J());
        }
        if (!TextUtils.isEmpty(this.pch.t())) {
            if (au.f5786b) {
                au.a("init config has abversion:" + this.pch.t(), null);
            }
            jSONObject.put("ab_version", this.pch.t());
        }
        if (!TextUtils.isEmpty(this.pch.K())) {
            jSONObject.put("ab_group", this.pch.K());
        }
        if (!TextUtils.isEmpty(this.pch.L())) {
            jSONObject.put("ab_feature", this.pch.L());
            return true;
        }
        return true;
    }
}
