package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView cpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.cpx = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.cpx.byf;
        if (i == 0) {
            scroller3 = this.cpx.cpe;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.cpx.cpe;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.cpx.cpp;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.cpx.getWidth() - this.cpx.getPaddingLeft()) - this.cpx.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.cpx.getWidth() - this.cpx.getPaddingLeft()) - this.cpx.getPaddingRight()) - 1), i3);
        }
        this.cpx.iy(-max);
        if (!computeScrollOffset) {
            scroller2 = this.cpx.cpe;
            scroller2.forceFinished(true);
            return;
        }
        this.cpx.cpp = currX;
        this.cpx.post(this);
    }
}
