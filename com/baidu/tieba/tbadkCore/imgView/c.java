package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fxG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fxG = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fxG.cCY;
        if (i == 0) {
            scroller3 = this.fxG.fxo;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fxG.fxo;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fxG.cCd;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fxG.getWidth() - this.fxG.getPaddingLeft()) - this.fxG.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fxG.getWidth() - this.fxG.getPaddingLeft()) - this.fxG.getPaddingRight()) - 1), i3);
        }
        this.fxG.rV(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fxG.fxo;
            scroller2.forceFinished(true);
            return;
        }
        this.fxG.cCd = currX;
        this.fxG.post(this);
    }
}
