package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService edy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.edy = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.edy.checkPassV6Switch();
    }
}
