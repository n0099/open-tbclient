package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class bx implements Runnable {
    final /* synthetic */ bw a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, ImageView imageView) {
        this.a = bwVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        KeyboardEventLayout keyboardEventLayout;
        bkVar = this.a.a;
        keyboardEventLayout = bkVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
