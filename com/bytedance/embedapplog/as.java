package com.bytedance.embedapplog;

import android.telephony.TelephonyManager;
/* loaded from: classes4.dex */
public class as {
    public static String a(TelephonyManager telephonyManager) {
        if (au.f6085b) {
            au.a("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
