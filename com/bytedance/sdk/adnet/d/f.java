package com.bytedance.sdk.adnet.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
/* loaded from: classes4.dex */
public class f {
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
            Log.e("ignored", th.toString());
        }
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                    return true;
                }
            }
        }
        return false;
    }
}
