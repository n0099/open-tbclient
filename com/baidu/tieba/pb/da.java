package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class da implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cz f2223a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cz czVar) {
        this.f2223a = czVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.f2223a.b.h;
        keyboardEventLayout.removeView(this.f2223a.f2221a);
    }
}
