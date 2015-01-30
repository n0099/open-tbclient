package com.baidu.tieba.service;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TiebaSyncService bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaSyncService tiebaSyncService) {
        this.bPb = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bPb.checkUpdata();
    }
}
