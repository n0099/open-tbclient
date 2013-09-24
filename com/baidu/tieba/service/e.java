package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.au;
import com.baidu.tieba.util.av;
import com.baidu.tieba.view.NoNetworkView;
/* loaded from: classes.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f1788a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.f1788a != 1) {
                        if (this.f1788a != -1) {
                            au.a().b(true);
                        }
                        this.f1788a = 1;
                    }
                } else if (this.f1788a != 2) {
                    if (this.f1788a != -1) {
                        au.a().b(false);
                    }
                    this.f1788a = 2;
                }
            } else if (this.f1788a != 0) {
                this.f1788a = 0;
            }
            CompatibleUtile.dealWebView();
        } catch (Exception e) {
            av.b("NetworkChangeReceiver", "onReceiver", e.getMessage());
        }
    }
}
