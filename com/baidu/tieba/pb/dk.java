package com.baidu.tieba.pb;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class dk implements Runnable {
    final /* synthetic */ dj a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar, ImageView imageView) {
        this.a = djVar;
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
