package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static TelephonyManager f3700a;
    private static ConnectivityManager b;

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        try {
            if (b == null) {
                b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            activeNetworkInfo = b.getActiveNetworkInfo();
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName(), e);
        }
        if (activeNetworkInfo == null) {
            com.baidu.ufosdk.f.c.d("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName());
            return "N/A";
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ").append(activeNetworkInfo.getTypeName()).append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append(" subType: ").append(activeNetworkInfo.getSubtypeName()).append("\n");
                if (f3700a == null) {
                    f3700a = (TelephonyManager) context.getSystemService("phone");
                }
                sb.append(" isRoaming: ").append(f3700a.isNetworkRoaming() ? "yes" : "no").append("\n");
            }
        } else {
            sb.append("type: none\n");
        }
        return sb.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(Context context) {
        try {
            if (b == null) {
                b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = b.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
            }
            com.baidu.ufosdk.f.c.d("getNetworkType fail, getActiveNetworkInfo() is null.");
            return RomUtils.UNKNOWN;
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("getNetworkType fail,", e);
            return RomUtils.UNKNOWN;
        }
    }

    public static boolean c(Context context) {
        String b2 = b(context);
        return (b2.contains(RomUtils.UNKNOWN) || b2.contains("NONE")) ? false : true;
    }
}
