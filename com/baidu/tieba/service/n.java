package com.baidu.tieba.service;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SyncLoginService bIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SyncLoginService syncLoginService) {
        this.bIP = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIP.checkPassV6Switch();
    }
}
