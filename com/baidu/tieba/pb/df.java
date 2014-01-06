package com.baidu.tieba.pb;

import android.widget.FrameLayout;
/* loaded from: classes.dex */
class df implements Runnable {
    final /* synthetic */ de a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(de deVar) {
        this.a = deVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        frameLayout = this.a.b.h;
        frameLayout.removeView(this.a.a);
    }
}
