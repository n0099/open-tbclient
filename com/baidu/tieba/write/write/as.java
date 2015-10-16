package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class as implements Runnable {
    final /* synthetic */ ar dqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.dqk = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.dqk.dqi;
        writeActivity.finish();
    }
}
