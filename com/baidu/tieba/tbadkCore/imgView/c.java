package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fzW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fzW = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fzW.cFp;
        if (i == 0) {
            scroller3 = this.fzW.fzE;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fzW.fzE;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fzW.cEu;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fzW.getWidth() - this.fzW.getPaddingLeft()) - this.fzW.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fzW.getWidth() - this.fzW.getPaddingLeft()) - this.fzW.getPaddingRight()) - 1), i3);
        }
        this.fzW.sb(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fzW.fzE;
            scroller2.forceFinished(true);
            return;
        }
        this.fzW.cEu = currX;
        this.fzW.post(this);
    }
}
