package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fmA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fmA = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bga;
        int bga2;
        boolean z;
        this.fmA.fmv = false;
        int childCount = this.fmA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fmA.getChildAt(i).clearAnimation();
        }
        canScroll = this.fmA.canScroll();
        if (!canScroll) {
            this.fmA.scrollTo(0, 0);
        } else {
            int scrollX = this.fmA.getScrollX();
            bga = this.fmA.bga();
            if (scrollX > bga) {
                DragHorizonScrollView dragHorizonScrollView = this.fmA;
                bga2 = this.fmA.bga();
                dragHorizonScrollView.scrollTo(bga2, 0);
            }
        }
        z = this.fmA.fmw;
        if (z) {
            this.fmA.requestLayout();
        }
    }
}
