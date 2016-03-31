package com.baidu.tieba.write.write;
/* loaded from: classes.dex */
class as implements Runnable {
    final /* synthetic */ ar eNe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.eNe = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteActivity writeActivity;
        writeActivity = this.eNe.eNd;
        writeActivity.finish();
    }
}
