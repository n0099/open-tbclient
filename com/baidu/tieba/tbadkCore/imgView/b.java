package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView cKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.cKb = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.cKb.bOI;
        if (i == 0) {
            scroller3 = this.cKb.cJI;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.cKb.cJI;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.cKb.cJT;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.cKb.getWidth() - this.cKb.getPaddingLeft()) - this.cKb.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.cKb.getWidth() - this.cKb.getPaddingLeft()) - this.cKb.getPaddingRight()) - 1), i3);
        }
        this.cKb.jM(-max);
        if (!computeScrollOffset) {
            scroller2 = this.cKb.cJI;
            scroller2.forceFinished(true);
            return;
        }
        this.cKb.cJT = currX;
        this.cKb.post(this);
    }
}
