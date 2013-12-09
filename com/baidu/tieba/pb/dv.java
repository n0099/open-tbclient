package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ du f2245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(du duVar) {
        this.f2245a = duVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        KeyboardEventLayout keyboardEventLayout2;
        keyboardEventLayout = this.f2245a.b.h;
        if (keyboardEventLayout != null) {
            keyboardEventLayout2 = this.f2245a.b.h;
            keyboardEventLayout2.removeView(this.f2245a.f2244a);
        }
    }
}
