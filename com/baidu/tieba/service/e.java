package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ TiebaActiveService fgG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TiebaActiveService tiebaActiveService) {
        this.fgG = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fgG.sendActive();
    }
}
