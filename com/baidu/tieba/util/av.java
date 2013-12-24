package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class av extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private av(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(NetWorkCoreByBdHttp netWorkCoreByBdHttp, as asVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.r();
        } catch (Exception e) {
            be.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
