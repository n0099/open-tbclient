package com.baidu.tieba.write;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.a = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.a.a;
        writeActivity.finish();
    }
}
