package com.baidu.tieba.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class p implements Runnable {
    private final /* synthetic */ int BF;
    final /* synthetic */ l bAL;
    private final /* synthetic */ View nt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, View view, int i) {
        this.bAL = lVar;
        this.nt = view;
        this.BF = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.nt != null) {
            int[] iArr = new int[2];
            this.bAL.azA.getLocationInWindow(iArr);
            this.bAL.vl.setSelectionFromTop(this.BF + 1, iArr[1] - this.nt.getHeight());
            this.bAL.vl.invalidate();
        }
    }
}
