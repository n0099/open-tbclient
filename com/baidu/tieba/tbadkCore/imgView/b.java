package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView daH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.daH = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.daH.bTb;
        if (i == 0) {
            scroller3 = this.daH.dam;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.daH.dam;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.daH.daz;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.daH.getWidth() - this.daH.getPaddingLeft()) - this.daH.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.daH.getWidth() - this.daH.getPaddingLeft()) - this.daH.getPaddingRight()) - 1), i3);
        }
        this.daH.la(-max);
        if (!computeScrollOffset) {
            scroller2 = this.daH.dam;
            scroller2.forceFinished(true);
            return;
        }
        this.daH.daz = currX;
        this.daH.post(this);
    }
}
