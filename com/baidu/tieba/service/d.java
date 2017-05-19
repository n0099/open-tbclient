package com.baidu.tieba.service;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ SyncLoginService feT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SyncLoginService syncLoginService) {
        this.feT = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.feT.checkPassV6Switch();
    }
}
