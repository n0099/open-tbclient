package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class da implements Runnable {
    final /* synthetic */ cz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cz czVar) {
        this.a = czVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        KeyboardEventLayout keyboardEventLayout;
        keyboardEventLayout = this.a.b.h;
        keyboardEventLayout.removeView(this.a.a);
    }
}
