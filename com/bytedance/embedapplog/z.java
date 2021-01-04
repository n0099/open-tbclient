package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class z extends ch {
    private final Context e;
    private final cn pgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context, cn cnVar) {
        super(true, false);
        this.e = context;
        this.pgJ = cnVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                m.a(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                m.a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                m.a(jSONObject, "udid", this.pgJ.O() ? as.a(telephonyManager) : this.pgJ.N());
                return true;
            } catch (Exception e) {
                au.a(e);
                return false;
            }
        }
        return false;
    }
}
