package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class z extends ch {
    private final Context e;
    private final cn pcg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pcg = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                m.a(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                m.a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                m.a(jSONObject, "udid", this.pcg.O() ? as.a(telephonyManager) : this.pcg.N());
                return true;
            } catch (Exception e) {
                au.a(e);
                return false;
            }
        }
        return false;
    }
}
