package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fOc = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fOc.mItemCount;
        if (i == 0) {
            scroller3 = this.fOc.fNJ;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fOc.fNJ;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fOc.cMs;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fOc.getWidth() - this.fOc.getPaddingLeft()) - this.fOc.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fOc.getWidth() - this.fOc.getPaddingLeft()) - this.fOc.getPaddingRight()) - 1), i3);
        }
        this.fOc.sI(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fOc.fNJ;
            scroller2.forceFinished(true);
            return;
        }
        this.fOc.cMs = currX;
        this.fOc.post(this);
    }
}
