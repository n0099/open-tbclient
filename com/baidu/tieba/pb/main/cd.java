package com.baidu.tieba.pb.main;

import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes.dex */
final class cd implements Runnable {
    final /* synthetic */ cc a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar, ImageView imageView) {
        this.a = ccVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bm bmVar;
        FrameLayout frameLayout;
        bmVar = this.a.a;
        frameLayout = bmVar.n;
        frameLayout.removeView(this.b);
    }
}
