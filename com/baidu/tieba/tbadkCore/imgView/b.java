package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView euH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.euH = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.euH.bSr;
        if (i == 0) {
            scroller3 = this.euH.eup;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.euH.eup;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.euH.bRw;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.euH.getWidth() - this.euH.getPaddingLeft()) - this.euH.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.euH.getWidth() - this.euH.getPaddingLeft()) - this.euH.getPaddingRight()) - 1), i3);
        }
        this.euH.pu(-max);
        if (!computeScrollOffset) {
            scroller2 = this.euH.eup;
            scroller2.forceFinished(true);
            return;
        }
        this.euH.bRw = currX;
        this.euH.post(this);
    }
}
