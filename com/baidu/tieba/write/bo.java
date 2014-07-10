package com.baidu.tieba.write;
/* loaded from: classes.dex */
class bo implements Runnable {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.a = bnVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.a.a;
        writeImageActivity.c("normal");
    }
}
