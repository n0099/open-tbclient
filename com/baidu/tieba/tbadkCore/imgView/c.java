package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fDX = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fDX.mItemCount;
        if (i == 0) {
            scroller3 = this.fDX.fDE;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fDX.fDE;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fDX.cEv;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fDX.getWidth() - this.fDX.getPaddingLeft()) - this.fDX.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fDX.getWidth() - this.fDX.getPaddingLeft()) - this.fDX.getPaddingRight()) - 1), i3);
        }
        this.fDX.sp(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fDX.fDE;
            scroller2.forceFinished(true);
            return;
        }
        this.fDX.cEv = currX;
        this.fDX.post(this);
    }
}
