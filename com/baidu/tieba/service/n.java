package com.baidu.tieba.service;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ TiebaSyncService bPa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TiebaSyncService tiebaSyncService) {
        this.bPa = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bPa.checkUpdata();
    }
}
