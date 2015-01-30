package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView caf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.caf = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.caf.bZJ;
        if (i == 0) {
            scroller3 = this.caf.bZM;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.caf.bZM;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.caf.bZX;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.caf.getWidth() - this.caf.getPaddingLeft()) - this.caf.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.caf.getWidth() - this.caf.getPaddingLeft()) - this.caf.getPaddingRight()) - 1), i3);
        }
        this.caf.id(-max);
        if (!computeScrollOffset) {
            scroller2 = this.caf.bZM;
            scroller2.forceFinished(true);
            return;
        }
        this.caf.bZX = currX;
        this.caf.post(this);
    }
}
