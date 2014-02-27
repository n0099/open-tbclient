package com.baidu.tieba.service;
/* loaded from: classes.dex */
final class j implements Runnable {
    final /* synthetic */ TiebaActiveService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(TiebaActiveService tiebaActiveService) {
        this.a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
