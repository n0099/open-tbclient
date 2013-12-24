package com.baidu.tieba.service;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ TiebaActiveService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(TiebaActiveService tiebaActiveService) {
        this.a = tiebaActiveService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.d();
    }
}
