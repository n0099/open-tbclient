package com.baidu.tieba.pb;

import com.baidu.tieba.view.KeyboardEventLayout;
/* loaded from: classes.dex */
class dt implements Runnable {
    final /* synthetic */ ds a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar) {
        this.a = dsVar;
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
