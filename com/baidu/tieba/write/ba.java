package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class ba implements Runnable {
    final /* synthetic */ WriteImagePreview a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteImagePreview writeImagePreview) {
        this.a = writeImagePreview;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a((Bitmap) null);
    }
}
