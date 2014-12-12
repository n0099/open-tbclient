package com.baidu.tieba.service;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TiebaSyncService bNr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaSyncService tiebaSyncService) {
        this.bNr = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bNr.checkUpdata();
    }
}
