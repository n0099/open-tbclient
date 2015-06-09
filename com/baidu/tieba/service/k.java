package com.baidu.tieba.service;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ TiebaSyncService cdF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TiebaSyncService tiebaSyncService) {
        this.cdF = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdF.checkUpdata();
    }
}
