package com.baidu.tieba.service;
/* loaded from: classes.dex */
final class f implements Runnable {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PerformMonitorService.c(this.a.a);
    }
}
