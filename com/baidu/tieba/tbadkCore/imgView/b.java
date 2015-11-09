package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView dcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.dcp = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.dcp.bTw;
        if (i == 0) {
            scroller3 = this.dcp.dbW;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.dcp.dbW;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.dcp.dch;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.dcp.getWidth() - this.dcp.getPaddingLeft()) - this.dcp.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.dcp.getWidth() - this.dcp.getPaddingLeft()) - this.dcp.getPaddingRight()) - 1), i3);
        }
        this.dcp.lo(-max);
        if (!computeScrollOffset) {
            scroller2 = this.dcp.dbW;
            scroller2.forceFinished(true);
            return;
        }
        this.dcp.dch = currX;
        this.dcp.post(this);
    }
}
