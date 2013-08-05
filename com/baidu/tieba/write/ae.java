package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.f1875a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1875a.a((Bitmap) null);
    }
}
