package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService eRn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.eRn = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eRn.checkPassV6Switch();
    }
}
