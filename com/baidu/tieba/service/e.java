package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService eIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.eIe = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eIe.checkPassV6Switch();
    }
}
