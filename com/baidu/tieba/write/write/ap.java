package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ap implements Runnable {
    final /* synthetic */ ao fQH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar) {
        this.fQH = aoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fQH.fQG;
        writeActivity.finish();
    }
}
