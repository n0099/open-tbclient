package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class bf extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private bf(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(NetWorkCoreByBdHttp netWorkCoreByBdHttp, bc bcVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.s();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
