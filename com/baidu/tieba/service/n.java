package com.baidu.tieba.service;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ SyncLoginService bJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SyncLoginService syncLoginService) {
        this.bJd = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bJd.checkPassV6Switch();
    }
}
