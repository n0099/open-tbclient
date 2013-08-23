package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class bz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ by f1529a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar, ImageView imageView) {
        this.f1529a = byVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bo boVar;
        KeyboardEventLayout keyboardEventLayout;
        boVar = this.f1529a.f1528a;
        keyboardEventLayout = boVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
