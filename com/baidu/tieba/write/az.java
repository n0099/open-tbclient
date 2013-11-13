package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImagePreview f2699a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteImagePreview writeImagePreview) {
        this.f2699a = writeImagePreview;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2699a.a((Bitmap) null);
    }
}
