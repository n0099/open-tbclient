package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.NoNetworkView;
/* loaded from: classes.dex */
public class f extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f2309a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.f2309a != 1) {
                        if (this.f2309a != -1) {
                            bd.a().b(true);
                        }
                        this.f2309a = 1;
                    }
                } else if (this.f2309a != 2) {
                    if (this.f2309a != -1) {
                        bd.a().b(false);
                    }
                    this.f2309a = 2;
                }
            } else if (this.f2309a != 0) {
                this.f2309a = 0;
            }
            CompatibleUtile.dealWebView();
        } catch (Exception e) {
            be.b("NetworkChangeReceiver", "onReceiver", e.getMessage());
        }
    }
}
