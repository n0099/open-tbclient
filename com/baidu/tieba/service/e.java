package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService cKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.cKA = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKA.checkPassV6Switch();
    }
}
