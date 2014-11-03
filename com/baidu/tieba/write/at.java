package com.baidu.tieba.write;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ as bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.bUo = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.bUo.bUm;
        writeActivity.finish();
    }
}
