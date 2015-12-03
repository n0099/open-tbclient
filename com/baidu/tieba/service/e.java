package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService dkM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.dkM = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dkM.checkPassV6Switch();
    }
}
