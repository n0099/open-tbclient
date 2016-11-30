package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fEg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fEg = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fEg.cQS;
        if (i == 0) {
            scroller3 = this.fEg.fDO;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fEg.fDO;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fEg.cPY;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fEg.getWidth() - this.fEg.getPaddingLeft()) - this.fEg.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fEg.getWidth() - this.fEg.getPaddingLeft()) - this.fEg.getPaddingRight()) - 1), i3);
        }
        this.fEg.sk(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fEg.fDO;
            scroller2.forceFinished(true);
            return;
        }
        this.fEg.cPY = currX;
        this.fEg.post(this);
    }
}
