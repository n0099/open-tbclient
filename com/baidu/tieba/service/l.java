package com.baidu.tieba.service;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ TiebaActiveService bOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TiebaActiveService tiebaActiveService) {
        this.bOZ = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bOZ.sendActive();
    }
}
