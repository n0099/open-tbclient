package com.baidu.tieba.pb;

import android.widget.FrameLayout;
/* loaded from: classes.dex */
class dc implements Runnable {
    final /* synthetic */ db a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(db dbVar) {
        this.a = dbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        frameLayout = this.a.b.h;
        frameLayout.removeView(this.a.a);
    }
}
