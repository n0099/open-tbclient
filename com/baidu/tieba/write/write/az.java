package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ ay cCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.cCS = ayVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.cCS.cCQ;
        writeActivity.finish();
    }
}
