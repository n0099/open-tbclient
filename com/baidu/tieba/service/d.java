package com.baidu.tieba.service;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ SyncLoginService fmL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SyncLoginService syncLoginService) {
        this.fmL = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fmL.checkPassV6Switch();
    }
}
