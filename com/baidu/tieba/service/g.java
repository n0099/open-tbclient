package com.baidu.tieba.service;
/* loaded from: classes.dex */
final class g implements Runnable {
    final /* synthetic */ PerformMonitorService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PerformMonitorService performMonitorService) {
        this.a = performMonitorService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a();
    }
}
