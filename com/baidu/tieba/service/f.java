package com.baidu.tieba.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ TiebaActiveService fds;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TiebaActiveService tiebaActiveService) {
        this.fds = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.fds.sendActive();
    }
}
