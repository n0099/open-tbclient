package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class bv implements Runnable {
    final /* synthetic */ bu a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, ImageView imageView) {
        this.a = buVar;
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
