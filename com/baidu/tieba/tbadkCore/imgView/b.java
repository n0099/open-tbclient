package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView bYm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.bYm = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.bYm.bXQ;
        if (i == 0) {
            scroller3 = this.bYm.bXT;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.bYm.bXT;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.bYm.bYe;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.bYm.getWidth() - this.bYm.getPaddingLeft()) - this.bYm.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.bYm.getWidth() - this.bYm.getPaddingLeft()) - this.bYm.getPaddingRight()) - 1), i3);
        }
        this.bYm.hU(-max);
        if (!computeScrollOffset) {
            scroller2 = this.bYm.bXT;
            scroller2.forceFinished(true);
            return;
        }
        this.bYm.bYe = currX;
        this.bYm.post(this);
    }
}
