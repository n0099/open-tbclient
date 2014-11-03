package com.baidu.tieba.service;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ TiebaActiveService bJe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaActiveService tiebaActiveService) {
        this.bJe = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bJe.sendActive();
    }
}
