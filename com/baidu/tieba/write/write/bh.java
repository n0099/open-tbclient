package com.baidu.tieba.write.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ WriteActivity cCQ;
    private final /* synthetic */ int cqX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity, int i) {
        this.cCQ = writeActivity;
        this.cqX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCQ.jE(this.cqX);
    }
}
