package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class bx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f1242a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar, ImageView imageView) {
        this.f1242a = bwVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk bkVar;
        KeyboardEventLayout keyboardEventLayout;
        bkVar = this.f1242a.f1241a;
        keyboardEventLayout = bkVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
