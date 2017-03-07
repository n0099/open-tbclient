package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fvW = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fvW.cEz;
        if (i == 0) {
            scroller3 = this.fvW.fvE;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fvW.fvE;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fvW.cDE;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fvW.getWidth() - this.fvW.getPaddingLeft()) - this.fvW.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fvW.getWidth() - this.fvW.getPaddingLeft()) - this.fvW.getPaddingRight()) - 1), i3);
        }
        this.fvW.rX(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fvW.fvE;
            scroller2.forceFinished(true);
            return;
        }
        this.fvW.cDE = currX;
        this.fvW.post(this);
    }
}
