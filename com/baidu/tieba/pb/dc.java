package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f2118a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(db dbVar) {
        this.f2118a = dbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.f2118a.b.h;
        keyboardEventLayout.removeView(this.f2118a.f2117a);
    }
}
