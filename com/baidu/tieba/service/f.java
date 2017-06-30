package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaSyncService fxc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaSyncService tiebaSyncService) {
        this.fxc = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fxc.checkUpdata();
    }
}
