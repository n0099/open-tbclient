package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService cMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.cMv = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cMv.checkPassV6Switch();
    }
}
