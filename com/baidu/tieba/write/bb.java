package com.baidu.tieba.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Runnable {
    private final /* synthetic */ int bUz;
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, int i) {
        this.cft = writeActivity;
        this.bUz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cft.ip(this.bUz);
    }
}
