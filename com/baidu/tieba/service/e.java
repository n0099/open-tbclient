package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService cDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.cDz = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cDz.checkPassV6Switch();
    }
}
