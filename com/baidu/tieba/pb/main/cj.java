package com.baidu.tieba.pb.main;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class cj implements Runnable {
    final /* synthetic */ ci a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ci ciVar, ImageView imageView) {
        this.a = ciVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bt btVar;
        FrameLayout frameLayout;
        btVar = this.a.a;
        frameLayout = btVar.l;
        frameLayout.removeView(this.b);
    }
}
