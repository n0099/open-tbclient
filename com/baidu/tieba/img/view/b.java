package com.baidu.tieba.img.view;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView blN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.blN = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.blN.blq;
        if (i == 0) {
            scroller3 = this.blN.blu;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.blN.blu;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.blN.blF;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.blN.getWidth() - this.blN.getPaddingLeft()) - this.blN.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.blN.getWidth() - this.blN.getPaddingLeft()) - this.blN.getPaddingRight()) - 1), i3);
        }
        this.blN.gq(-max);
        if (!computeScrollOffset) {
            scroller2 = this.blN.blu;
            scroller2.forceFinished(true);
            return;
        }
        this.blN.blF = currX;
        this.blN.post(this);
    }
}
