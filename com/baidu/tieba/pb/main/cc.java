package com.baidu.tieba.pb.main;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class cc implements Runnable {
    final /* synthetic */ cb a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar, ImageView imageView) {
        this.a = cbVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bj bjVar;
        FrameLayout frameLayout;
        bjVar = this.a.a;
        frameLayout = bjVar.n;
        frameLayout.removeView(this.b);
    }
}
