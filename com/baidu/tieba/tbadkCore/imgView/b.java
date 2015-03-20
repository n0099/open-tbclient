package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView cph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.cph = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.cph.bxP;
        if (i == 0) {
            scroller3 = this.cph.coO;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.cph.coO;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.cph.coZ;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.cph.getWidth() - this.cph.getPaddingLeft()) - this.cph.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.cph.getWidth() - this.cph.getPaddingLeft()) - this.cph.getPaddingRight()) - 1), i3);
        }
        this.cph.iv(-max);
        if (!computeScrollOffset) {
            scroller2 = this.cph.coO;
            scroller2.forceFinished(true);
            return;
        }
        this.cph.coZ = currX;
        this.cph.post(this);
    }
}
