package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class au implements Runnable {
    final /* synthetic */ at dsc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.dsc = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.dsc.dsa;
        writeActivity.finish();
    }
}
