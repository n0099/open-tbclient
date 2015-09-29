package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class as implements Runnable {
    final /* synthetic */ ar dpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.dpK = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.dpK.dpI;
        writeActivity.finish();
    }
}
