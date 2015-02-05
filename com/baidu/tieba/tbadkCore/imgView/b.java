package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView cae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.cae = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.cae.bZI;
        if (i == 0) {
            scroller3 = this.cae.bZL;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.cae.bZL;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.cae.bZW;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.cae.getWidth() - this.cae.getPaddingLeft()) - this.cae.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.cae.getWidth() - this.cae.getPaddingLeft()) - this.cae.getPaddingRight()) - 1), i3);
        }
        this.cae.id(-max);
        if (!computeScrollOffset) {
            scroller2 = this.cae.bZL;
            scroller2.forceFinished(true);
            return;
        }
        this.cae.bZW = currX;
        this.cae.post(this);
    }
}
