package com.baidu.tieba.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ l a;
    private final /* synthetic */ View b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, View view, int i) {
        this.a = lVar;
        this.b = view;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b != null) {
            int[] iArr = new int[2];
            this.a.M.getLocationInWindow(iArr);
            this.a.d.setSelectionFromTop(this.c + 1, iArr[1] - this.b.getHeight());
            this.a.d.invalidate();
        }
    }
}
