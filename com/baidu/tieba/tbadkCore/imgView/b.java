package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView fuu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.fuu = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fuu.cKL;
        if (i == 0) {
            scroller3 = this.fuu.fuc;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fuu.fuc;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fuu.cJR;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fuu.getWidth() - this.fuu.getPaddingLeft()) - this.fuu.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fuu.getWidth() - this.fuu.getPaddingLeft()) - this.fuu.getPaddingRight()) - 1), i3);
        }
        this.fuu.rE(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fuu.fuc;
            scroller2.forceFinished(true);
            return;
        }
        this.fuu.cJR = currX;
        this.fuu.post(this);
    }
}
