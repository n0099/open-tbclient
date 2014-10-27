package com.baidu.tieba.img.view;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView blz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.blz = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.blz.blc;
        if (i == 0) {
            scroller3 = this.blz.blg;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.blz.blg;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.blz.blr;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.blz.getWidth() - this.blz.getPaddingLeft()) - this.blz.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.blz.getWidth() - this.blz.getPaddingLeft()) - this.blz.getPaddingRight()) - 1), i3);
        }
        this.blz.gq(-max);
        if (!computeScrollOffset) {
            scroller2 = this.blz.blg;
            scroller2.forceFinished(true);
            return;
        }
        this.blz.blr = currX;
        this.blz.post(this);
    }
}
