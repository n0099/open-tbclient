package com.baidu.tieba.service;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ PerformMonitorService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.monitorOff();
    }
}
