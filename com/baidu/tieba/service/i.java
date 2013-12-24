package com.baidu.tieba.service;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a.c();
    }
}
