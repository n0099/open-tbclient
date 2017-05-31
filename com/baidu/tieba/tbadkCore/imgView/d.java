package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fDX = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int biA;
        int biA2;
        boolean z;
        this.fDX.fDR = false;
        int childCount = this.fDX.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fDX.getChildAt(i).clearAnimation();
        }
        canScroll = this.fDX.canScroll();
        if (!canScroll) {
            this.fDX.scrollTo(0, 0);
        } else {
            int scrollX = this.fDX.getScrollX();
            biA = this.fDX.biA();
            if (scrollX > biA) {
                DragHorizonScrollView dragHorizonScrollView = this.fDX;
                biA2 = this.fDX.biA();
                dragHorizonScrollView.scrollTo(biA2, 0);
            }
        }
        z = this.fDX.fDS;
        if (z) {
            this.fDX.requestLayout();
        }
    }
}
