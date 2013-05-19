package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class bw implements Runnable {
    final /* synthetic */ bv a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bv bvVar, ImageView imageView) {
        this.a = bvVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bl blVar;
        KeyboardEventLayout keyboardEventLayout;
        blVar = this.a.a;
        keyboardEventLayout = blVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
