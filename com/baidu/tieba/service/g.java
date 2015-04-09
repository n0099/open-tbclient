package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ SyncLoginService bZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SyncLoginService syncLoginService) {
        this.bZp = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZp.checkPassV6Switch();
    }
}
