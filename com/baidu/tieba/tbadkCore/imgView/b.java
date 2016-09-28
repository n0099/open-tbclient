package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView fxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.fxa = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fxa.cLC;
        if (i == 0) {
            scroller3 = this.fxa.fwI;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fxa.fwI;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fxa.cKI;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fxa.getWidth() - this.fxa.getPaddingLeft()) - this.fxa.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fxa.getWidth() - this.fxa.getPaddingLeft()) - this.fxa.getPaddingRight()) - 1), i3);
        }
        this.fxa.rS(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fxa.fwI;
            scroller2.forceFinished(true);
            return;
        }
        this.fxa.cKI = currX;
        this.fxa.post(this);
    }
}
