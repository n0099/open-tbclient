package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.bv;
import com.baidu.tieba.view.NoNetworkView;
/* loaded from: classes.dex */
public final class e extends BroadcastReceiver {
    public int a = -1;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.a != 1) {
                        if (this.a != -1) {
                            bv.a().a(true);
                            com.baidu.tieba.im.message.u uVar = new com.baidu.tieba.im.message.u(-121);
                            uVar.a(1);
                            com.baidu.tieba.im.messageCenter.d.a().d(uVar);
                        }
                        this.a = 1;
                    }
                } else if (this.a != 2) {
                    if (this.a != -1) {
                        bv.a().a(false);
                        com.baidu.tieba.im.message.u uVar2 = new com.baidu.tieba.im.message.u(-121);
                        uVar2.a(2);
                        com.baidu.tieba.im.messageCenter.d.a().d(uVar2);
                    }
                    this.a = 2;
                }
            } else if (this.a != 0) {
                this.a = 0;
                com.baidu.tieba.im.message.u uVar3 = new com.baidu.tieba.im.message.u(-121);
                uVar3.a(0);
                com.baidu.tieba.im.messageCenter.d.a().d(uVar3);
            }
            CompatibleUtile.dealWebView();
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b("NetworkChangeReceiver", "onReceiver", th.getMessage());
        }
    }
}
