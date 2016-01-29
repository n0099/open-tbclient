package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ TiebaSyncService dIb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TiebaSyncService tiebaSyncService) {
        this.dIb = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dIb.checkUpdata();
    }
}
