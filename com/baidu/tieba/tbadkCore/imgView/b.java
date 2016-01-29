package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView dYG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.dYG = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.dYG.bHt;
        if (i == 0) {
            scroller3 = this.dYG.dYo;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.dYG.dYo;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.dYG.bGy;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.dYG.getWidth() - this.dYG.getPaddingLeft()) - this.dYG.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.dYG.getWidth() - this.dYG.getPaddingLeft()) - this.dYG.getPaddingRight()) - 1), i3);
        }
        this.dYG.op(-max);
        if (!computeScrollOffset) {
            scroller2 = this.dYG.dYo;
            scroller2.forceFinished(true);
            return;
        }
        this.dYG.bGy = currX;
        this.dYG.post(this);
    }
}
