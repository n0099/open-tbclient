package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView dIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.dIG = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.dIG.bEh;
        if (i == 0) {
            scroller3 = this.dIG.dIo;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.dIG.dIo;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.dIG.bDm;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.dIG.getWidth() - this.dIG.getPaddingLeft()) - this.dIG.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.dIG.getWidth() - this.dIG.getPaddingLeft()) - this.dIG.getPaddingRight()) - 1), i3);
        }
        this.dIG.nc(-max);
        if (!computeScrollOffset) {
            scroller2 = this.dIG.dIo;
            scroller2.forceFinished(true);
            return;
        }
        this.dIG.bDm = currX;
        this.dIG.post(this);
    }
}
