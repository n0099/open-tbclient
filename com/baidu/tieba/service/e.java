package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ TiebaActiveService fmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TiebaActiveService tiebaActiveService) {
        this.fmM = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fmM.sendActive();
    }
}
