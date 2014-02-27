package com.baidu.tieba.pb;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ek implements Runnable {
    final /* synthetic */ ed a;
    private final /* synthetic */ int b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ek(ed edVar, int i, View view) {
        this.a = edVar;
        this.b = i;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int[] iArr = new int[2];
        this.a.L.getLocationInWindow(iArr);
        this.a.c.setSelectionFromTop(this.b + 1, iArr[1] - this.c.getHeight());
        this.a.c.invalidate();
    }
}
