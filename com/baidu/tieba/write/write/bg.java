package com.baidu.tieba.write.write;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements Runnable {
    private final /* synthetic */ int cmX;
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity, int i) {
        this.cyx = writeActivity;
        this.cmX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cyx.ji(this.cmX);
    }
}
