package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class u extends ch {
    private final Context e;
    private final cn ppe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Context context, cn cnVar) {
        super(false, false);
        this.e = context;
        this.ppe = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        int i;
        int i2;
        String packageName = this.e.getPackageName();
        if (TextUtils.isEmpty(this.ppe.eoC())) {
            jSONObject.put("package", packageName);
        } else {
            if (au.b) {
                au.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.ppe.eoC());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.e.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable th) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th2) {
                au.a(th2);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.ppe.H())) {
            jSONObject.put("app_version", this.ppe.H());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.ppe.M())) {
            jSONObject.put("app_version_minor", this.ppe.M());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.ppe.E() != 0) {
            jSONObject.put("version_code", this.ppe.E());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.ppe.F() != 0) {
            jSONObject.put("update_version_code", this.ppe.F());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.ppe.G() != 0) {
            jSONObject.put("manifest_version_code", this.ppe.G());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.ppe.D())) {
            jSONObject.put("app_name", this.ppe.D());
        }
        if (!TextUtils.isEmpty(this.ppe.I())) {
            jSONObject.put("tweaked_channel", this.ppe.I());
        }
        if (packageInfo != null && packageInfo.applicationInfo != null && (i2 = packageInfo.applicationInfo.labelRes) > 0) {
            jSONObject.put("display_name", this.e.getString(i2));
        }
        return true;
    }
}
