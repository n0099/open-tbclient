package com.baidu.tieba.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ TiebaActiveService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TiebaActiveService tiebaActiveService) {
        this.a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d();
    }
}
