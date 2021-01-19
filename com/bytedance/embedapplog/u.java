package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class u extends ch {
    private final Context e;
    private final cn pch;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.pch = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        int i;
        String packageName = this.e.getPackageName();
        if (TextUtils.isEmpty(this.pch.elT())) {
            jSONObject.put("package", packageName);
        } else {
            if (au.f5786b) {
                au.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.pch.elT());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(packageName, 0);
            int i2 = packageInfo.versionCode;
            if (!TextUtils.isEmpty(this.pch.H())) {
                jSONObject.put("app_version", this.pch.H());
            } else {
                jSONObject.put("app_version", packageInfo.versionName);
            }
            if (!TextUtils.isEmpty(this.pch.M())) {
                jSONObject.put("app_version_minor", this.pch.M());
            } else {
                jSONObject.put("app_version_minor", "");
            }
            if (this.pch.E() != 0) {
                jSONObject.put("version_code", this.pch.E());
            } else {
                jSONObject.put("version_code", i2);
            }
            if (this.pch.F() != 0) {
                jSONObject.put("update_version_code", this.pch.F());
            } else {
                jSONObject.put("update_version_code", i2);
            }
            if (this.pch.G() != 0) {
                jSONObject.put("manifest_version_code", this.pch.G());
            } else {
                jSONObject.put("manifest_version_code", i2);
            }
            if (!TextUtils.isEmpty(this.pch.D())) {
                jSONObject.put("app_name", this.pch.D());
            }
            if (!TextUtils.isEmpty(this.pch.I())) {
                jSONObject.put("tweaked_channel", this.pch.I());
            }
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.e.getString(i));
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            au.a(e);
            return false;
        }
    }
}
