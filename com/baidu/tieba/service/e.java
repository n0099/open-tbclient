package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ SyncLoginService fns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SyncLoginService syncLoginService) {
        this.fns = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fns.checkPassV6Switch();
    }
}
