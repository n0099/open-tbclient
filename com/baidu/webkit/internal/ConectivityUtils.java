package com.baidu.webkit.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
/* loaded from: classes7.dex */
public class ConectivityUtils implements INoProGuard {
    public static final String APN_3GNET = "3gnet";
    public static final String APN_3GWAP = "3gwap";
    public static final String APN_CMNET = "cmnet";
    public static final String APN_CMWAP = "cmwap";
    public static final String APN_CTNET = "ctnet";
    public static final String APN_CTWAP = "ctwap";
    public static final String APN_UNINET = "uninet";
    public static final String APN_UNIWAP = "uniwap";
    public static final String APN_UNKNOWN = "unknown";
    public static final String APN_WIFI = "wifi";
    public static final String LOG_TAG = "ConectivityUtils";
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_5G = "5g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    public static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");

    public static String getNetType(Context context) {
        Context applicationContext;
        ConnectivityManager connectivityManager;
        if (context == null) {
            return "unknown";
        }
        try {
            applicationContext = context.getApplicationContext();
            connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connectivityManager == null) {
            return "unknown";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo == null || !networkInfo.isConnected()) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            return (networkInfo2 == null || !networkInfo2.isConnected()) ? "unknown" : "wifi";
        } else if (isFastMobileNetwork(applicationContext)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager.getNetworkType() == 13 ? "4g" : telephonyManager.getNetworkType() == 20 ? "5g" : "3g";
        } else {
            return "2g";
        }
    }

    public static boolean isFastMobileNetwork(Context context) {
        int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        if (networkType != 3 && networkType != 20 && networkType != 5 && networkType != 6) {
            switch (networkType) {
                case 8:
                case 9:
                case 10:
                    break;
                default:
                    switch (networkType) {
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }
}
