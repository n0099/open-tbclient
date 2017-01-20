package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ap implements Runnable {
    final /* synthetic */ ao fMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.fMm = aoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fMm.fMl;
        writeActivity.finish();
    }
}
