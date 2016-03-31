package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView erx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.erx = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aTR;
        int aTR2;
        boolean z;
        this.erx.ers = false;
        int childCount = this.erx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.erx.getChildAt(i).clearAnimation();
        }
        canScroll = this.erx.canScroll();
        if (!canScroll) {
            this.erx.scrollTo(0, 0);
        } else {
            int scrollX = this.erx.getScrollX();
            aTR = this.erx.aTR();
            if (scrollX > aTR) {
                DragHorizonScrollView dragHorizonScrollView = this.erx;
                aTR2 = this.erx.aTR();
                dragHorizonScrollView.scrollTo(aTR2, 0);
            }
        }
        z = this.erx.ert;
        if (z) {
            this.erx.requestLayout();
        }
    }
}
