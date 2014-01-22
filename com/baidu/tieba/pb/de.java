package com.baidu.tieba.pb;

import android.widget.FrameLayout;
/* loaded from: classes.dex */
class de implements Runnable {
    final /* synthetic */ dd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.a = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        frameLayout = this.a.b.h;
        frameLayout.removeView(this.a.a);
    }
}
