package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ WriteImagePreview a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteImagePreview writeImagePreview) {
        this.a = writeImagePreview;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a((Bitmap) null);
    }
}
