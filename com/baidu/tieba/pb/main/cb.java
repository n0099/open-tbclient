package com.baidu.tieba.pb.main;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
final class cb implements Runnable {
    final /* synthetic */ ca a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar, ImageView imageView) {
        this.a = caVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bk bkVar;
        FrameLayout frameLayout;
        bkVar = this.a.a;
        frameLayout = bkVar.n;
        frameLayout.removeView(this.b);
    }
}
