package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bz f1495a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, ImageView imageView) {
        this.f1495a = bzVar;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        bn bnVar;
        KeyboardEventLayout keyboardEventLayout;
        bnVar = this.f1495a.f1494a;
        keyboardEventLayout = bnVar.c;
        keyboardEventLayout.removeView(this.b);
    }
}
