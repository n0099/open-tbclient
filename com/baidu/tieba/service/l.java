package com.baidu.tieba.service;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ PerformMonitorService bJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PerformMonitorService performMonitorService) {
        this.bJb = performMonitorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bJb.monitorOff();
    }
}
