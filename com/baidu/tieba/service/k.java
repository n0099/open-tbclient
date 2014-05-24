package com.baidu.tieba.service;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ SyncLoginService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SyncLoginService syncLoginService) {
        this.a = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.checkPassV6Switch();
    }
}
