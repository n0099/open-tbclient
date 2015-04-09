package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ ax cyz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.cyz = axVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.cyz.cyx;
        writeActivity.finish();
    }
}
