package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.os.Build;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class ci extends ch {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ci() {
        super(true, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    @SuppressLint({"MissingPermission"})
    public boolean a(JSONObject jSONObject) {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", Build.SERIAL);
        if (Build.VERSION.SDK_INT >= 26) {
            jSONObject.put("build_serial", Build.getSerial());
            return true;
        }
        return true;
    }
}
