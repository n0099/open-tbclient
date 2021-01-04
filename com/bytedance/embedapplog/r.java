package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class r extends ch {
    private final Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context) {
        super(true, true);
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    @SuppressLint({"MissingPermission"})
    public boolean a(JSONObject jSONObject) {
        m.a(jSONObject, "access", ar.b(this.e));
        return true;
    }
}
