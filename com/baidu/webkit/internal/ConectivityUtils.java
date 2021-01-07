package com.baidu.webkit.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
/* loaded from: classes15.dex */
public class ConectivityUtils implements INoProGuard {
    private static final String APN_3GNET = "3gnet";
    private static final String APN_3GWAP = "3gwap";
    private static final String APN_CMNET = "cmnet";
    private static final String APN_CMWAP = "cmwap";
    private static final String APN_CTNET = "ctnet";
    private static final String APN_CTWAP = "ctwap";
    private static final String APN_UNINET = "uninet";
    private static final String APN_UNIWAP = "uniwap";
    private static final String APN_UNKNOWN = "unknown";
    private static final String APN_WIFI = "wifi";
    private static final String LOG_TAG = "ConectivityUtils";
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x005e -> B:30:0x0005). Please submit an issue!!! */
    public static String getNetType(Context context) {
        String str;
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
            str = "unknown";
        } else {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    str = "wifi";
                }
                str = "unknown";
            } else {
                str = isFastMobileNetwork(applicationContext) ? ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 13 ? "4g" : "3g" : "2g";
            }
        }
        return str;
    }

    private static boolean isFastMobileNetwork(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return false;
            case 8:
                return true;
            case 9:
                return true;
            case 10:
                return true;
            case 11:
                return false;
            case 12:
                return true;
            case 13:
                return true;
            case 14:
                return true;
            case 15:
                return true;
            default:
                return false;
        }
    }
}
