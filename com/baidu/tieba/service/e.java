package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService cKZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.cKZ = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cKZ.checkPassV6Switch();
    }
}
