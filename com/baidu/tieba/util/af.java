package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class af extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f1895a;

    private af(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f1895a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(NetWorkCoreByBdHttp netWorkCoreByBdHttp, af afVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.f1895a.r();
        } catch (Exception e) {
            av.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
