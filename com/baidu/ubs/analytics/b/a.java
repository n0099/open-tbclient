package com.baidu.ubs.analytics.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.ubs.analytics.b.b;
import com.baidu.ubs.analytics.c.f;
import com.baidu.ubs.analytics.c.i;
/* loaded from: classes8.dex */
public final class a {
    public static boolean a(Context context, String str) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (!f.g() || i.j(context) == 1) {
                return b.a(b.a(str, "http://absample.baidu.com/appabapp/appapi/applog"), (b.a) null);
            }
            return false;
        }
        return false;
    }
}
