package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class x extends ch {
    private final Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Context context) {
        super(true, false);
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature signature;
        try {
            packageInfo = this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 64);
        } catch (Exception e) {
            au.a(e);
            packageInfo = null;
        }
        String b2 = (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || (signature = packageInfo.signatures[0]) == null) ? null : ap.b(signature.toByteArray());
        if (b2 != null) {
            jSONObject.put("sig_hash", b2);
            return true;
        }
        return true;
    }
}
