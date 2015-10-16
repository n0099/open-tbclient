package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService cLa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.cLa = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cLa.sendActive();
    }
}
