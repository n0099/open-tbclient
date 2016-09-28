package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService ffZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.ffZ = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ffZ.checkPassV6Switch();
    }
}
