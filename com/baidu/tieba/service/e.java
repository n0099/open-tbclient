package com.baidu.tieba.service;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ TiebaActiveService feU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TiebaActiveService tiebaActiveService) {
        this.feU = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.feU.sendActive();
    }
}
