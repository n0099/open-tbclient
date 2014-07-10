package com.baidu.tieba.img.view;

import android.widget.Scroller;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ DragHorizonScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(DragHorizonScrollView dragHorizonScrollView) {
        this.a = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Scroller scroller;
        int i2;
        int max;
        Scroller scroller2;
        Scroller scroller3;
        i = this.a.f;
        if (i == 0) {
            scroller3 = this.a.m;
            scroller3.forceFinished(true);
            return;
        }
        scroller = this.a.m;
        boolean computeScrollOffset = scroller.computeScrollOffset();
        int currX = scroller.getCurrX();
        i2 = this.a.B;
        int i3 = i2 - currX;
        if (i3 > 0) {
            max = Math.min(((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - 1, i3);
        } else {
            max = Math.max(-(((this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight()) - 1), i3);
        }
        this.a.b(-max);
        if (!computeScrollOffset) {
            scroller2 = this.a.m;
            scroller2.forceFinished(true);
            return;
        }
        this.a.B = currX;
        this.a.post(this);
    }
}
