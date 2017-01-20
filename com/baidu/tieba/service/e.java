package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService faI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.faI = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.faI.checkPassV6Switch();
    }
}
