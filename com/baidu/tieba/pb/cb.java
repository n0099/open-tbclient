package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ca f1531a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar, ImageView imageView) {
        this.f1531a = caVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        KeyboardEventLayout keyboardEventLayout;
        boVar = this.f1531a.f1530a;
        keyboardEventLayout = boVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
