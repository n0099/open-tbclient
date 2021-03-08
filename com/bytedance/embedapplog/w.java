package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w extends ch {
    private final cn ppf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(cn cnVar) {
        super(true, false, false);
        this.ppf = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        SharedPreferences eox = this.ppf.eox();
        String string = eox.getString("install_id", null);
        String string2 = eox.getString("device_id", null);
        String string3 = eox.getString("ssid", null);
        m.a(jSONObject, "install_id", string);
        m.a(jSONObject, "device_id", string2);
        m.a(jSONObject, "ssid", string3);
        long j = eox.getLong("register_time", 0L);
        if ((!m.e(string) || !m.e(string2)) && j != 0) {
            eox.edit().putLong("register_time", 0L).apply();
            j = 0;
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
