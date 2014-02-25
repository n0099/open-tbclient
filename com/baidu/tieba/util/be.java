package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class be extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private be(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(NetWorkCoreByBdHttp netWorkCoreByBdHttp, be beVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.s();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
