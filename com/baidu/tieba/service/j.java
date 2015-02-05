package com.baidu.tieba.service;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ SyncLoginService bOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SyncLoginService syncLoginService) {
        this.bOX = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOX.checkPassV6Switch();
    }
}
