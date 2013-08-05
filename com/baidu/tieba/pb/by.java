package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f1493a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar, ImageView imageView) {
        this.f1493a = bxVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        KeyboardEventLayout keyboardEventLayout;
        bnVar = this.f1493a.f1492a;
        keyboardEventLayout = bnVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
