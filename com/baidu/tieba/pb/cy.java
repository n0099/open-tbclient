package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class cy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cx f2130a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cx cxVar) {
        this.f2130a = cxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.f2130a.b.h;
        keyboardEventLayout.removeView(this.f2130a.f2129a);
    }
}
