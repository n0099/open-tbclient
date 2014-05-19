package com.baidu.tieba.write;
/* loaded from: classes.dex */
class an implements Runnable {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.a.a;
        writeActivity.finish();
    }
}
