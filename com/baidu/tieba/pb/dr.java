package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dq f2150a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar) {
        this.f2150a = dqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        KeyboardEventLayout keyboardEventLayout2;
        keyboardEventLayout = this.f2150a.b.h;
        if (keyboardEventLayout != null) {
            keyboardEventLayout2 = this.f2150a.b.h;
            keyboardEventLayout2.removeView(this.f2150a.f2149a);
        }
    }
}
