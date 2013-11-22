package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ax extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f2476a;

    private ax(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f2476a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(NetWorkCoreByBdHttp netWorkCoreByBdHttp, au auVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.f2476a.r();
        } catch (Exception e) {
            bg.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
