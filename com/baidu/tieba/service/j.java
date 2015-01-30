package com.baidu.tieba.service;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ SyncLoginService bOY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SyncLoginService syncLoginService) {
        this.bOY = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOY.checkPassV6Switch();
    }
}
