package com.baidu.tieba.pb.main;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
class cf implements Runnable {
    final /* synthetic */ ce a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar, ImageView imageView) {
        this.a = ceVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bs bsVar;
        FrameLayout frameLayout;
        bsVar = this.a.a;
        frameLayout = bsVar.l;
        frameLayout.removeView(this.b);
    }
}
