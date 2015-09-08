package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView cSB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.cSB = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.cSB.bPo;
        if (i == 0) {
            scroller3 = this.cSB.cSi;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.cSB.cSi;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.cSB.cSt;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.cSB.getWidth() - this.cSB.getPaddingLeft()) - this.cSB.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.cSB.getWidth() - this.cSB.getPaddingLeft()) - this.cSB.getPaddingRight()) - 1), i3);
        }
        this.cSB.kx(-max);
        if (!computeScrollOffset) {
            scroller2 = this.cSB.cSi;
            scroller2.forceFinished(true);
            return;
        }
        this.cSB.cSt = currX;
        this.cSB.post(this);
    }
}
