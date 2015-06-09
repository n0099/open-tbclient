package com.baidu.tieba.service;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ TiebaActiveService cdD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(TiebaActiveService tiebaActiveService) {
        this.cdD = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cdD.sendActive();
    }
}
