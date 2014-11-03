package com.baidu.tieba.service;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j bJc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bJc = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PerformMonitorService performMonitorService;
        performMonitorService = this.bJc.bJb;
        performMonitorService.startUpLoad();
    }
}
