package com.baidu.tieba.service;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {
    final /* synthetic */ TiebaSyncService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TiebaSyncService tiebaSyncService) {
        this.a = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b();
    }
}
