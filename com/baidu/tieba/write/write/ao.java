package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ an fSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.fSr = anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fSr.fSq;
        writeActivity.finish();
    }
}
