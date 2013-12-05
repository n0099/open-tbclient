package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class au extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f2589a;

    private au(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f2589a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ au(NetWorkCoreByBdHttp netWorkCoreByBdHttp, ar arVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.f2589a.r();
        } catch (Exception e) {
            bd.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
