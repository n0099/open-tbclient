package com.baidu.tieba.service;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ TiebaActiveService bIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TiebaActiveService tiebaActiveService) {
        this.bIQ = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIQ.sendActive();
    }
}
