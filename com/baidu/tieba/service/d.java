package com.baidu.tieba.service;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ SyncLoginService fwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SyncLoginService syncLoginService) {
        this.fwZ = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fwZ.checkPassV6Switch();
    }
}
