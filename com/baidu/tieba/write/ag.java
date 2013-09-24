package com.baidu.tieba.write;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.f2084a = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2084a.a((Bitmap) null);
    }
}
