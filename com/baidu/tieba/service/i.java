package com.baidu.tieba.service;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ TiebaActiveService bZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TiebaActiveService tiebaActiveService) {
        this.bZq = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bZq.sendActive();
    }
}
