package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.bx;
import com.baidu.tieba.view.NoNetworkView;
/* loaded from: classes.dex */
public class f extends BroadcastReceiver {
    public int a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.a != 1) {
                        if (this.a != -1) {
                            bx.a().b(true);
                            com.baidu.tieba.im.message.s sVar = new com.baidu.tieba.im.message.s(-121);
                            sVar.a(1);
                            com.baidu.tieba.im.messageCenter.e.a().d(sVar);
                        }
                        this.a = 1;
                    }
                } else if (this.a != 2) {
                    if (this.a != -1) {
                        bx.a().b(false);
                        com.baidu.tieba.im.message.s sVar2 = new com.baidu.tieba.im.message.s(-121);
                        sVar2.a(2);
                        com.baidu.tieba.im.messageCenter.e.a().d(sVar2);
                    }
                    this.a = 2;
                }
            } else if (this.a != 0) {
                this.a = 0;
                com.baidu.tieba.im.message.s sVar3 = new com.baidu.tieba.im.message.s(-121);
                sVar3.a(0);
                com.baidu.tieba.im.messageCenter.e.a().d(sVar3);
            }
            CompatibleUtile.dealWebView();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("NetworkChangeReceiver", "onReceiver", e.getMessage());
        }
    }
}
