package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bz f2088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.f2088a = bzVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.f2088a.b.d;
        keyboardEventLayout.removeView(this.f2088a.f2087a);
    }
}
