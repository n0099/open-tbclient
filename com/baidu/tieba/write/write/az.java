package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ ay cCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.cCR = ayVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.cCR.cCP;
        writeActivity.finish();
    }
}
