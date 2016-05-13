package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ as fec;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fec = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fec.fea;
        writeActivity.finish();
    }
}
