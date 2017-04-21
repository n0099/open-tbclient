package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ao implements Runnable {
    final /* synthetic */ an fUN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.fUN = anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fUN.fUM;
        writeActivity.finish();
    }
}
