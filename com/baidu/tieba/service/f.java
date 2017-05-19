package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaSyncService feW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaSyncService tiebaSyncService) {
        this.feW = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.feW.checkUpdata();
    }
}
