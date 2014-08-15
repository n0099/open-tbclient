package com.baidu.tieba.write;
/* loaded from: classes.dex */
class bt implements Runnable {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bo boVar) {
        this.a = boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WriteImageActivity writeImageActivity;
        writeImageActivity = this.a.a;
        writeImageActivity.c("normal");
    }
}
