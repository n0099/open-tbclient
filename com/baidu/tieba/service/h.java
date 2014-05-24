package com.baidu.tieba.service;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PerformMonitorService performMonitorService;
        performMonitorService = this.a.a;
        performMonitorService.startUpLoad();
    }
}
