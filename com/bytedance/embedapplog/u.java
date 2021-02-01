package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class u extends ch {
    private final Context e;
    private final cn pmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.pmw = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        int i;
        String packageName = this.e.getPackageName();
        if (TextUtils.isEmpty(this.pmw.eon())) {
            jSONObject.put("package", packageName);
        } else {
            if (au.f5788b) {
                au.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.pmw.eon());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(packageName, 0);
            int i2 = packageInfo.versionCode;
            if (!TextUtils.isEmpty(this.pmw.H())) {
                jSONObject.put("app_version", this.pmw.H());
            } else {
                jSONObject.put("app_version", packageInfo.versionName);
            }
            if (!TextUtils.isEmpty(this.pmw.M())) {
                jSONObject.put("app_version_minor", this.pmw.M());
            } else {
                jSONObject.put("app_version_minor", "");
            }
            if (this.pmw.E() != 0) {
                jSONObject.put("version_code", this.pmw.E());
            } else {
                jSONObject.put("version_code", i2);
            }
            if (this.pmw.F() != 0) {
                jSONObject.put("update_version_code", this.pmw.F());
            } else {
                jSONObject.put("update_version_code", i2);
            }
            if (this.pmw.G() != 0) {
                jSONObject.put("manifest_version_code", this.pmw.G());
            } else {
                jSONObject.put("manifest_version_code", i2);
            }
            if (!TextUtils.isEmpty(this.pmw.D())) {
                jSONObject.put("app_name", this.pmw.D());
            }
            if (!TextUtils.isEmpty(this.pmw.I())) {
                jSONObject.put("tweaked_channel", this.pmw.I());
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
