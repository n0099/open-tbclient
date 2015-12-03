package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView dBd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.dBd = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.dBd.cjK;
        if (i == 0) {
            scroller3 = this.dBd.dAK;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.dBd.dAK;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.dBd.dAV;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.dBd.getWidth() - this.dBd.getPaddingLeft()) - this.dBd.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.dBd.getWidth() - this.dBd.getPaddingLeft()) - this.dBd.getPaddingRight()) - 1), i3);
        }
        this.dBd.mA(-max);
        if (!computeScrollOffset) {
            scroller2 = this.dBd.dAK;
            scroller2.forceFinished(true);
            return;
        }
        this.dBd.dAV = currX;
        this.dBd.post(this);
    }
}
