package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.ctz = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.ctz.bAQ;
        if (i == 0) {
            scroller3 = this.ctz.ctg;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.ctz.ctg;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.ctz.ctr;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.ctz.getWidth() - this.ctz.getPaddingLeft()) - this.ctz.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.ctz.getWidth() - this.ctz.getPaddingLeft()) - this.ctz.getPaddingRight()) - 1), i3);
        }
        this.ctz.iU(-max);
        if (!computeScrollOffset) {
            scroller2 = this.ctz.ctg;
            scroller2.forceFinished(true);
            return;
        }
        this.ctz.ctr = currX;
        this.ctz.post(this);
    }
}
