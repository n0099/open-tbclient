package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService faJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.faJ = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.faJ.sendActive();
    }
}
