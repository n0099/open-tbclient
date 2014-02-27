package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
final class be extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private be(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(NetWorkCoreByBdHttp netWorkCoreByBdHttp, byte b) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            this.a.s();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
