package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ TiebaSyncService ffh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TiebaSyncService tiebaSyncService) {
        this.ffh = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ffh.checkUpdata();
    }
}
