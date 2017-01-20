package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView frz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.frz = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.frz.cDd;
        if (i == 0) {
            scroller3 = this.frz.frg;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.frz.frg;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.frz.cCi;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.frz.getWidth() - this.frz.getPaddingLeft()) - this.frz.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.frz.getWidth() - this.frz.getPaddingLeft()) - this.frz.getPaddingRight()) - 1), i3);
        }
        this.frz.rY(-max);
        if (!computeScrollOffset) {
            scroller2 = this.frz.frg;
            scroller2.forceFinished(true);
            return;
        }
        this.frz.cCi = currX;
        this.frz.post(this);
    }
}
