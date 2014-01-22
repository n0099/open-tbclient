package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eh implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ View b;
    final /* synthetic */ eb c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(eb ebVar, int i, View view) {
        this.c = ebVar;
        this.a = i;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.c.L.getLocationInWindow(iArr);
        this.c.c.setSelectionFromTop(this.a + 1, iArr[1] - this.b.getHeight());
        this.c.c.invalidate();
    }
}
