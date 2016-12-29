package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class aq implements Runnable {
    final /* synthetic */ ap fDR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.fDR = apVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.fDR.fDQ;
        writeActivity.finish();
    }
}
