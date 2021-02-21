package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class w extends ch {
    private final cn pmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(cn cnVar) {
        super(true, false, false);
        this.pmX = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        SharedPreferences eoo = this.pmX.eoo();
        String string = eoo.getString("install_id", null);
        String string2 = eoo.getString("device_id", null);
        String string3 = eoo.getString("ssid", null);
        m.a(jSONObject, "install_id", string);
        m.a(jSONObject, "device_id", string2);
        m.a(jSONObject, "ssid", string3);
        long j = eoo.getLong("register_time", 0L);
        if ((!m.e(string) || !m.e(string2)) && j != 0) {
            eoo.edit().putLong("register_time", 0L).apply();
            j = 0;
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
