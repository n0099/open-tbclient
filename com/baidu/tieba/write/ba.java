package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteImagePreview f2684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteImagePreview writeImagePreview) {
        this.f2684a = writeImagePreview;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2684a.a((Bitmap) null);
    }
}
