package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    private final /* synthetic */ int aru;
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, int i) {
        this.bUm = writeActivity;
        this.aru = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bUm.hH(this.aru);
    }
}
