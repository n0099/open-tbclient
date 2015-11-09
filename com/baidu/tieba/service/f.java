package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService cMw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.cMw = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cMw.sendActive();
    }
}
