package com.baidu.tieba.write;
/* loaded from: classes.dex */
class bp implements Runnable {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.a.a;
        writeImageActivity.c("normal");
    }
}
