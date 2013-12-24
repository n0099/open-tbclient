package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dv implements Runnable {
    final /* synthetic */ du a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(du duVar) {
        this.a = duVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        KeyboardEventLayout keyboardEventLayout2;
        keyboardEventLayout = this.a.b.h;
        if (keyboardEventLayout != null) {
            keyboardEventLayout2 = this.a.b.h;
            keyboardEventLayout2.removeView(this.a.a);
        }
    }
}
