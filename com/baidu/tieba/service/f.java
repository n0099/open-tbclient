package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService fff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.fff = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fff.sendActive();
    }
}
