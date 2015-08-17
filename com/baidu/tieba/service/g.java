package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ TiebaSyncService cvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TiebaSyncService tiebaSyncService) {
        this.cvg = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cvg.checkUpdata();
    }
}
