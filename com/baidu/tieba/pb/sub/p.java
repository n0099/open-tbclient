package com.baidu.tieba.pb.sub;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    private final /* synthetic */ int BG;
    final /* synthetic */ l bAZ;
    private final /* synthetic */ View nt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, View view, int i) {
        this.bAZ = lVar;
        this.nt = view;
        this.BG = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.nt != null) {
            int[] iArr = new int[2];
            this.bAZ.azJ.getLocationInWindow(iArr);
            this.bAZ.vl.setSelectionFromTop(this.BG + 1, iArr[1] - this.nt.getHeight());
            this.bAZ.vl.invalidate();
        }
    }
}
