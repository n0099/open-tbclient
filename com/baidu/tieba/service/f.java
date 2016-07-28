package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService eVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.eVh = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eVh.sendActive();
    }
}
