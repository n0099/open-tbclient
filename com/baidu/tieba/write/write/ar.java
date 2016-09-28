package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ aq ghE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar) {
        this.ghE = aqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.ghE.ghD;
        writeActivity.finish();
    }
}
