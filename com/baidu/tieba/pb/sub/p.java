package com.baidu.tieba.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class p implements Runnable {
    private final /* synthetic */ int FV;
    final /* synthetic */ l bGx;
    private final /* synthetic */ View nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, View view, int i) {
        this.bGx = lVar;
        this.nv = view;
        this.FV = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.nv != null) {
            int[] iArr = new int[2];
            this.bGx.aCF.getLocationInWindow(iArr);
            this.bGx.mListView.setSelectionFromTop(this.FV + 1, iArr[1] - this.nv.getHeight());
            this.bGx.mListView.invalidate();
        }
    }
}
