package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ao extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f2425a;

    private ao(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f2425a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(NetWorkCoreByBdHttp netWorkCoreByBdHttp, al alVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.f2425a.r();
        } catch (Exception e) {
            be.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
