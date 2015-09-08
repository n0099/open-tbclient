package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class as implements Runnable {
    final /* synthetic */ ar ddS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.ddS = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.ddS.ddQ;
        writeActivity.finish();
    }
}
