package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ ax cye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.cye = axVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.cye.cyc;
        writeActivity.finish();
    }
}
