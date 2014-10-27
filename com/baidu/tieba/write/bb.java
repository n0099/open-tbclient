package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    private final /* synthetic */ int arl;
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, int i) {
        this.bTX = writeActivity;
        this.arl = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bTX.hH(this.arl);
    }
}
