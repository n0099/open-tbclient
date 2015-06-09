package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ SyncLoginService cdC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SyncLoginService syncLoginService) {
        this.cdC = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdC.checkPassV6Switch();
    }
}
