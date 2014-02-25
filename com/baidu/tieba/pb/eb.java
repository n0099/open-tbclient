package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class eb implements Runnable {
    final /* synthetic */ ea a;
    private final /* synthetic */ int b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(ea eaVar, int i, View view) {
        this.a = eaVar;
        this.b = i;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        NavigationBar navigationBar;
        int[] iArr = new int[2];
        this.a.L.getLocationInWindow(iArr);
        int height = iArr[1] - this.c.getHeight();
        navigationBar = this.a.Q;
        this.a.c.setSelectionFromTop(this.b + 1, height - navigationBar.getHeight());
        this.a.c.invalidate();
    }
}
