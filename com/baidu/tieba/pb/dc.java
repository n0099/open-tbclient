package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dc implements Runnable {
    final /* synthetic */ db a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(db dbVar) {
        this.a = dbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.a.b.h;
        keyboardEventLayout.removeView(this.a.a);
    }
}
