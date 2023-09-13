package com.bytedance.pangle.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
/* loaded from: classes9.dex */
public final class a {
    public static volatile a a;

    @SuppressLint({"MissingPermission"})
    public static EnumC0562a a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return EnumC0562a.WIFI;
                }
                if (type == 0) {
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return EnumC0562a.MOBILE_3G;
                        case 4:
                        case 7:
                        case 11:
                        default:
                            return EnumC0562a.MOBILE;
                        case 13:
                            return EnumC0562a.MOBILE_4G;
                    }
                }
                return EnumC0562a.MOBILE;
            }
            return EnumC0562a.NONE;
        } catch (Throwable unused) {
            return EnumC0562a.MOBILE;
        }
    }

    /* renamed from: com.bytedance.pangle.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public enum EnumC0562a {
        UNKNOWN(-1),
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        
        public final int h;

        EnumC0562a(int i2) {
            this.h = i2;
        }
    }
}
