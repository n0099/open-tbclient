package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f1790a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PerformMonitorService performMonitorService;
        performMonitorService = this.f1790a.f1789a;
        performMonitorService.c();
    }
}
