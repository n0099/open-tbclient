package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class at implements Runnable {
    final /* synthetic */ as fed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.fed = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fed.feb;
        writeActivity.finish();
    }
}
