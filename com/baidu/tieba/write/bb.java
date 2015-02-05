package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    private final /* synthetic */ int bWq;
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, int i) {
        this.cgR = writeActivity;
        this.bWq = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cgR.iu(this.bWq);
    }
}
