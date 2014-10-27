package com.baidu.tieba.service;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ PerformMonitorService bIN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PerformMonitorService performMonitorService) {
        this.bIN = performMonitorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIN.monitorOff();
    }
}
