package com.baidu.tieba.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ab extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkCoreByBdHttp f1776a;

    private ab(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.f1776a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(NetWorkCoreByBdHttp netWorkCoreByBdHttp, ab abVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.f1776a.q();
        } catch (Exception e) {
            aq.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
