package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService fdr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.fdr = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fdr.checkPassV6Switch();
    }
}
