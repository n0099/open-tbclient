package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService fnt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.fnt = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fnt.sendActive();
    }
}
