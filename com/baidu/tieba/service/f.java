package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService eat;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.eat = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eat.sendActive();
    }
}
