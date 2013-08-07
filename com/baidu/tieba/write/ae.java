package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.f1873a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1873a.a((Bitmap) null);
    }
}
