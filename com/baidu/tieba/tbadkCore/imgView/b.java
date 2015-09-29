package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView daf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.daf = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.daf.bSQ;
        if (i == 0) {
            scroller3 = this.daf.cZM;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.daf.cZM;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.daf.cZX;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.daf.getWidth() - this.daf.getPaddingLeft()) - this.daf.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.daf.getWidth() - this.daf.getPaddingLeft()) - this.daf.getPaddingRight()) - 1), i3);
        }
        this.daf.kY(-max);
        if (!computeScrollOffset) {
            scroller2 = this.daf.cZM;
            scroller2.forceFinished(true);
            return;
        }
        this.daf.cZX = currX;
        this.daf.post(this);
    }
}
