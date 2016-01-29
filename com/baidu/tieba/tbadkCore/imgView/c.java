package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView dYG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.dYG = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aMQ;
        int aMQ2;
        boolean z;
        this.dYG.dYB = false;
        int childCount = this.dYG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.dYG.getChildAt(i).clearAnimation();
        }
        canScroll = this.dYG.canScroll();
        if (!canScroll) {
            this.dYG.scrollTo(0, 0);
        } else {
            int scrollX = this.dYG.getScrollX();
            aMQ = this.dYG.aMQ();
            if (scrollX > aMQ) {
                DragHorizonScrollView dragHorizonScrollView = this.dYG;
                aMQ2 = this.dYG.aMQ();
                dragHorizonScrollView.scrollTo(aMQ2, 0);
            }
        }
        z = this.dYG.dYC;
        if (z) {
            this.dYG.requestLayout();
        }
    }
}
