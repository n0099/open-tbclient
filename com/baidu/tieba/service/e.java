package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService dHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.dHY = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dHY.checkPassV6Switch();
    }
}
