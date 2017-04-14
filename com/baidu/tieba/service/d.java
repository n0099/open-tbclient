package com.baidu.tieba.service;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ SyncLoginService fgF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SyncLoginService syncLoginService) {
        this.fgF = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fgF.checkPassV6Switch();
    }
}
