package com.baidu.tieba.write.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements Runnable {
    private final /* synthetic */ int cmH;
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity, int i) {
        this.cyc = writeActivity;
        this.cmH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyc.jf(this.cmH);
    }
}
