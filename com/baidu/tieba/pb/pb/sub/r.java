package com.baidu.tieba.pb.pb.sub;

import android.view.View;
/* loaded from: classes.dex */
class r implements Runnable {
    private final /* synthetic */ int Rx;
    final /* synthetic */ l bOf;
    private final /* synthetic */ View yS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, View view, int i) {
        this.bOf = lVar;
        this.yS = view;
        this.Rx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.yS != null) {
            int[] iArr = new int[2];
            this.bOf.aIy.getLocationInWindow(iArr);
            this.bOf.mListView.setSelectionFromTop(this.Rx + 1, iArr[1] - this.yS.getHeight());
            this.bOf.mListView.invalidate();
        }
    }
}
