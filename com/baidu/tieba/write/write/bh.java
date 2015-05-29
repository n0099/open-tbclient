package com.baidu.tieba.write.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements Runnable {
    final /* synthetic */ WriteActivity cCP;
    private final /* synthetic */ int cqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity, int i) {
        this.cCP = writeActivity;
        this.cqW = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cCP.jE(this.cqW);
    }
}
