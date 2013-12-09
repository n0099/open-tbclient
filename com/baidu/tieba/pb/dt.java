package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ds f2243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar) {
        this.f2243a = dsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        KeyboardEventLayout keyboardEventLayout2;
        keyboardEventLayout = this.f2243a.b.h;
        if (keyboardEventLayout != null) {
            keyboardEventLayout2 = this.f2243a.b.h;
            keyboardEventLayout2.removeView(this.f2243a.f2242a);
        }
    }
}
