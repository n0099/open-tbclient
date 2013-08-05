package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.webkit.WebView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.aj;
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f1701a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.f1701a != 1) {
                        if (this.f1701a != -1 && TiebaApplication.f().bb()) {
                            TiebaApplication.f().y(true);
                        }
                        this.f1701a = 1;
                    }
                } else if (this.f1701a != 2) {
                    if (this.f1701a != -1 && TiebaApplication.f().bb()) {
                        TiebaApplication.f().y(false);
                    }
                    this.f1701a = 2;
                }
            } else if (this.f1701a != 0) {
                this.f1701a = 0;
            }
            WebView.disablePlatformNotifications();
            WebView.enablePlatformNotifications();
        } catch (Exception e) {
            aj.b("NetworkChangeReceiver", "onReceiver", e.getMessage());
        }
    }
}
