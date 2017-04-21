package com.baidu.tieba.service;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ SyncLoginService fiY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SyncLoginService syncLoginService) {
        this.fiY = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fiY.checkPassV6Switch();
    }
}
