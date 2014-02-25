package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PerformMonitorService performMonitorService;
        performMonitorService = this.a.a;
        performMonitorService.c();
    }
}
