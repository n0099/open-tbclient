package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    private final /* synthetic */ int bWr;
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, int i) {
        this.cgS = writeActivity;
        this.bWr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cgS.iu(this.bWr);
    }
}
