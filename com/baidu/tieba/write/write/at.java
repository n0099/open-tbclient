package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ as fSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fSW = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fSW.fSV;
        writeActivity.finish();
    }
}
