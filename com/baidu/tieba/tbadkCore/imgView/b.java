package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView erx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.erx = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.erx.bRQ;
        if (i == 0) {
            scroller3 = this.erx.erf;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.erx.erf;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.erx.bQV;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.erx.getWidth() - this.erx.getPaddingLeft()) - this.erx.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.erx.getWidth() - this.erx.getPaddingLeft()) - this.erx.getPaddingRight()) - 1), i3);
        }
        this.erx.pz(-max);
        if (!computeScrollOffset) {
            scroller2 = this.erx.erf;
            scroller2.forceFinished(true);
            return;
        }
        this.erx.bQV = currX;
        this.erx.post(this);
    }
}
