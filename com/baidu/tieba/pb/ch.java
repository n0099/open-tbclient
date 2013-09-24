package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class ch implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cg f1579a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, ImageView imageView) {
        this.f1579a = cgVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        KeyboardEventLayout keyboardEventLayout;
        brVar = this.f1579a.f1578a;
        keyboardEventLayout = brVar.d;
        keyboardEventLayout.removeView(this.b);
    }
}
