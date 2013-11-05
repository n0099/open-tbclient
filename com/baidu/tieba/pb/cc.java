package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class cc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f2090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.f2090a = cbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.f2090a.b.d;
        keyboardEventLayout.removeView(this.f2090a.f2089a);
    }
}
