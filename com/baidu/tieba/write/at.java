package com.baidu.tieba.write;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ as cgU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.cgU = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.cgU.cgS;
        writeActivity.finish();
    }
}
