package com.baidu.tieba.service;
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PerformMonitorService f1791a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PerformMonitorService performMonitorService) {
        this.f1791a = performMonitorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1791a.b();
    }
}
