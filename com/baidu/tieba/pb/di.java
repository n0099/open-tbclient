package com.baidu.tieba.pb;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class di implements Runnable {
    final /* synthetic */ dh a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar, ImageView imageView) {
        this.a = dhVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        cu cuVar;
        FrameLayout frameLayout;
        cuVar = this.a.a;
        frameLayout = cuVar.i;
        frameLayout.removeView(this.b);
    }
}
