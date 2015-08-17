package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService cvd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.cvd = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cvd.checkPassV6Switch();
    }
}
