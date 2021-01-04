package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y extends ch {
    private final Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context) {
        super(true, false);
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        m.a(jSONObject, "sim_region", ((TelephonyManager) this.e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
