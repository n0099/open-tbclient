package com.bytedance.embedapplog;

import android.telephony.TelephonyManager;
/* loaded from: classes6.dex */
public class as {
    public static String a(TelephonyManager telephonyManager) {
        if (au.b) {
            au.a("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
