package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class r implements Runnable {
    private final /* synthetic */ int Rz;
    final /* synthetic */ l bOv;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, View view, int i) {
        this.bOv = lVar;
        this.yS = view;
        this.Rz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.yS != null) {
            int[] iArr = new int[2];
            this.bOv.aIG.getLocationInWindow(iArr);
            this.bOv.mListView.setSelectionFromTop(this.Rz + 1, iArr[1] - this.yS.getHeight());
            this.bOv.mListView.invalidate();
        }
    }
}
