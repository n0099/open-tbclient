package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView eZx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.eZx = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.eZx.cwr;
        if (i == 0) {
            scroller3 = this.eZx.eZf;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.eZx.eZf;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.eZx.cvx;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.eZx.getWidth() - this.eZx.getPaddingLeft()) - this.eZx.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.eZx.getWidth() - this.eZx.getPaddingLeft()) - this.eZx.getPaddingRight()) - 1), i3);
        }
        this.eZx.qJ(-max);
        if (!computeScrollOffset) {
            scroller2 = this.eZx.eZf;
            scroller2.forceFinished(true);
            return;
        }
        this.eZx.cvx = currX;
        this.eZx.post(this);
    }
}
