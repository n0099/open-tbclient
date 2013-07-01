package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bu f1240a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, ImageView imageView) {
        this.f1240a = buVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        KeyboardEventLayout keyboardEventLayout;
        bkVar = this.f1240a.f1239a;
        keyboardEventLayout = bkVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
