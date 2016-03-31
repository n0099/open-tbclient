package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService eas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.eas = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eas.checkPassV6Switch();
    }
}
