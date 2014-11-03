package com.baidu.tieba.service;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ TiebaSyncService bJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TiebaSyncService tiebaSyncService) {
        this.bJg = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bJg.checkUpdata();
    }
}
