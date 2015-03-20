package com.baidu.tieba.service;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ TiebaSyncService bZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TiebaSyncService tiebaSyncService) {
        this.bZd = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZd.checkUpdata();
    }
}
