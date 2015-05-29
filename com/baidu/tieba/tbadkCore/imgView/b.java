package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView cty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.cty = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.cty.bAP;
        if (i == 0) {
            scroller3 = this.cty.ctf;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.cty.ctf;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.cty.ctq;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.cty.getWidth() - this.cty.getPaddingLeft()) - this.cty.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.cty.getWidth() - this.cty.getPaddingLeft()) - this.cty.getPaddingRight()) - 1), i3);
        }
        this.cty.iU(-max);
        if (!computeScrollOffset) {
            scroller2 = this.cty.ctf;
            scroller2.forceFinished(true);
            return;
        }
        this.cty.ctq = currX;
        this.cty.post(this);
    }
}
