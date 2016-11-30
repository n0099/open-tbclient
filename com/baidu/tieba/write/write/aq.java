package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class aq implements Runnable {
    final /* synthetic */ ap gpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.gpq = apVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.gpq.gpp;
        writeActivity.finish();
    }
}
