package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fwf = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fwf.czz;
        if (i == 0) {
            scroller3 = this.fwf.fvM;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fwf.fvM;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fwf.cyE;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fwf.getWidth() - this.fwf.getPaddingLeft()) - this.fwf.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fwf.getWidth() - this.fwf.getPaddingLeft()) - this.fwf.getPaddingRight()) - 1), i3);
        }
        this.fwf.rT(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fwf.fvM;
            scroller2.forceFinished(true);
            return;
        }
        this.fwf.cyE = currX;
        this.fwf.post(this);
    }
}
