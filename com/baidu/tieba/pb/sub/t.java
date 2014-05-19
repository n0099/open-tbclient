package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ m a;
    private final /* synthetic */ int b;
    private final /* synthetic */ View c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar, int i, View view) {
        this.a = mVar;
        this.b = i;
        this.c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.a.L.getLocationInWindow(iArr);
        this.a.d.setSelectionFromTop(this.b + 1, iArr[1] - this.c.getHeight());
        this.a.d.invalidate();
    }
}
