package com.baidu.tieba.service;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1703a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PerformMonitorService performMonitorService;
        performMonitorService = this.f1703a.f1702a;
        performMonitorService.c();
    }
}
