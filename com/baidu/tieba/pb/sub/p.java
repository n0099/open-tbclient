package com.baidu.tieba.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class p implements Runnable {
    private final /* synthetic */ int FS;
    final /* synthetic */ l bGw;
    private final /* synthetic */ View nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, View view, int i) {
        this.bGw = lVar;
        this.nv = view;
        this.FS = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.nv != null) {
            int[] iArr = new int[2];
            this.bGw.aCC.getLocationInWindow(iArr);
            this.bGw.mListView.setSelectionFromTop(this.FS + 1, iArr[1] - this.nv.getHeight());
            this.bGw.mListView.invalidate();
        }
    }
}
