package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f23307a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f23308b;

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        String str = "\n";
        StringBuilder sb = new StringBuilder();
        try {
            if (f23308b == null) {
                f23308b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            activeNetworkInfo = f23308b.getActiveNetworkInfo();
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName(), e2);
        }
        if (activeNetworkInfo == null) {
            com.baidu.ufosdk.f.c.d("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName());
            return "N/A";
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ");
            sb.append(activeNetworkInfo.getTypeName());
            sb.append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append(" subType: ");
                sb.append(activeNetworkInfo.getSubtypeName());
                sb.append("\n");
                if (f23307a == null) {
                    f23307a = (TelephonyManager) context.getSystemService("phone");
                }
                sb.append(" isRoaming: ");
                sb.append(f23307a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str = "type: none\n";
        sb.append(str);
        return sb.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(Context context) {
        try {
            if (f23308b == null) {
                f23308b = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f23308b.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
            }
            com.baidu.ufosdk.f.c.d("getNetworkType fail, getActiveNetworkInfo() is null.");
            return RomUtils.UNKNOWN;
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("getNetworkType fail,", e2);
            return RomUtils.UNKNOWN;
        }
    }

    public static boolean c(Context context) {
        String b2 = b(context);
        return (b2.contains(RomUtils.UNKNOWN) || b2.contains("NONE")) ? false : true;
    }
}
