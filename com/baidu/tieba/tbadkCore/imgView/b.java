package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView fmA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.fmA = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fmA.czg;
        if (i == 0) {
            scroller3 = this.fmA.fmi;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fmA.fmi;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fmA.cym;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fmA.getWidth() - this.fmA.getPaddingLeft()) - this.fmA.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fmA.getWidth() - this.fmA.getPaddingLeft()) - this.fmA.getPaddingRight()) - 1), i3);
        }
        this.fmA.re(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fmA.fmi;
            scroller2.forceFinished(true);
            return;
        }
        this.fmA.cym = currX;
        this.fmA.post(this);
    }
}
