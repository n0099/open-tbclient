package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ SyncLoginService bZa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SyncLoginService syncLoginService) {
        this.bZa = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZa.checkPassV6Switch();
    }
}
