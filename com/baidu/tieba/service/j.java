package com.baidu.tieba.service;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ SyncLoginService bNo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SyncLoginService syncLoginService) {
        this.bNo = syncLoginService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bNo.checkPassV6Switch();
    }
}
