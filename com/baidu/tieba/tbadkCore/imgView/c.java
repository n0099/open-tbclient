package com.baidu.tieba.tbadkCore.imgView;

import android.widget.Scroller;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fil = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.fil.cvZ;
        if (i == 0) {
            scroller3 = this.fil.fhS;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.fil.fhS;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.fil.cve;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.fil.getWidth() - this.fil.getPaddingLeft()) - this.fil.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.fil.getWidth() - this.fil.getPaddingLeft()) - this.fil.getPaddingRight()) - 1), i3);
        }
        this.fil.rn(-max);
        if (!computeScrollOffset) {
            scroller2 = this.fil.fhS;
            scroller2.forceFinished(true);
            return;
        }
        this.fil.cve = currX;
        this.fil.post(this);
    }
}
