package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.aq;
import com.baidu.tieba.view.NoNetworkView;
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public int f1716a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.f1716a != 1) {
                        if (this.f1716a != -1 && TiebaApplication.g().aR()) {
                            TiebaApplication.g().x(true);
                        }
                        this.f1716a = 1;
                    }
                } else if (this.f1716a != 2) {
                    if (this.f1716a != -1 && TiebaApplication.g().aR()) {
                        TiebaApplication.g().x(false);
                    }
                    this.f1716a = 2;
                }
            } else if (this.f1716a != 0) {
                this.f1716a = 0;
            }
            CompatibleUtile.dealWebView();
        } catch (Exception e) {
            aq.b("NetworkChangeReceiver", "onReceiver", e.getMessage());
        }
    }
}
