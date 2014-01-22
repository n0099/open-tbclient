package com.baidu.tieba.pb;

import android.widget.FrameLayout;
/* loaded from: classes.dex */
class db implements Runnable {
    final /* synthetic */ da a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(da daVar) {
        this.a = daVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        frameLayout = this.a.b.h;
        frameLayout.removeView(this.a.a);
    }
}
