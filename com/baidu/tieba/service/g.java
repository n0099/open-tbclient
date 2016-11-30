package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ TiebaSyncService fnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TiebaSyncService tiebaSyncService) {
        this.fnv = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fnv.checkUpdata();
    }
}
