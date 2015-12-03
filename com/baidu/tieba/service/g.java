package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ TiebaSyncService dkP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TiebaSyncService tiebaSyncService) {
        this.dkP = tiebaSyncService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dkP.checkUpdata();
    }
}
