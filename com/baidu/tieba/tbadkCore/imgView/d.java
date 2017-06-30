package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fOc = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bmO;
        int bmO2;
        boolean z;
        this.fOc.fNW = false;
        int childCount = this.fOc.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fOc.getChildAt(i).clearAnimation();
        }
        canScroll = this.fOc.canScroll();
        if (!canScroll) {
            this.fOc.scrollTo(0, 0);
        } else {
            int scrollX = this.fOc.getScrollX();
            bmO = this.fOc.bmO();
            if (scrollX > bmO) {
                DragHorizonScrollView dragHorizonScrollView = this.fOc;
                bmO2 = this.fOc.bmO();
                dragHorizonScrollView.scrollTo(bmO2, 0);
            }
        }
        z = this.fOc.fNX;
        if (z) {
            this.fOc.requestLayout();
        }
    }
}
