package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ TiebaActiveService fxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TiebaActiveService tiebaActiveService) {
        this.fxa = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fxa.sendActive();
    }
}
