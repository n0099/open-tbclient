package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class au implements Runnable {
    final /* synthetic */ at dRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.dRg = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.dRg.dRf;
        writeActivity.finish();
    }
}
