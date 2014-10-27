package com.baidu.tieba.service;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ TiebaSyncService bIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TiebaSyncService tiebaSyncService) {
        this.bIS = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIS.checkUpdata();
    }
}
