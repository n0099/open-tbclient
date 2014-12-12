package com.baidu.tieba.service;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ TiebaActiveService bNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TiebaActiveService tiebaActiveService) {
        this.bNp = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bNp.sendActive();
    }
}
