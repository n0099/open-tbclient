package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class cf extends ch {
    private final Context e;
    private final cn ppe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.ppe = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.ppe.up())) {
            jSONObject.put("ab_client", this.ppe.up());
        }
        if (!TextUtils.isEmpty(this.ppe.t())) {
            if (au.b) {
                au.a("init config has abversion:" + this.ppe.t(), null);
            }
            jSONObject.put("ab_version", this.ppe.t());
        }
        if (!TextUtils.isEmpty(this.ppe.uq())) {
            jSONObject.put("ab_group", this.ppe.uq());
        }
        if (!TextUtils.isEmpty(this.ppe.L())) {
            jSONObject.put("ab_feature", this.ppe.L());
            return true;
        }
        return true;
    }
}
