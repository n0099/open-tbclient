package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class bb extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private bb(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(NetWorkCoreByBdHttp netWorkCoreByBdHttp, ay ayVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.r();
        } catch (Exception e) {
            bo.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
