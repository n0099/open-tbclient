package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView eZx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.eZx = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bcL;
        int bcL2;
        boolean z;
        this.eZx.eZs = false;
        int childCount = this.eZx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.eZx.getChildAt(i).clearAnimation();
        }
        canScroll = this.eZx.canScroll();
        if (!canScroll) {
            this.eZx.scrollTo(0, 0);
        } else {
            int scrollX = this.eZx.getScrollX();
            bcL = this.eZx.bcL();
            if (scrollX > bcL) {
                DragHorizonScrollView dragHorizonScrollView = this.eZx;
                bcL2 = this.eZx.bcL();
                dragHorizonScrollView.scrollTo(bcL2, 0);
            }
        }
        z = this.eZx.eZt;
        if (z) {
            this.eZx.requestLayout();
        }
    }
}
