package com.baidu.tieba.service;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ TiebaSyncService cdE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TiebaSyncService tiebaSyncService) {
        this.cdE = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdE.checkUpdata();
    }
}
