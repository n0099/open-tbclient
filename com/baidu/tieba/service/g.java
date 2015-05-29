package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ SyncLoginService cdB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SyncLoginService syncLoginService) {
        this.cdB = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdB.checkPassV6Switch();
    }
}
