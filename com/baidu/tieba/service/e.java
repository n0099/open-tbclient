package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService drU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.drU = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.drU.checkPassV6Switch();
    }
}
