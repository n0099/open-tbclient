package com.baidu.tieba.write;
/* loaded from: classes.dex */
class br implements Runnable {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.a.a;
        writeImageActivity.c("normal");
    }
}
