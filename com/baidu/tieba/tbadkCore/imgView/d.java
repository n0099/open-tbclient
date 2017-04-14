package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fxG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fxG = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int biI;
        int biI2;
        boolean z;
        this.fxG.fxB = false;
        int childCount = this.fxG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fxG.getChildAt(i).clearAnimation();
        }
        canScroll = this.fxG.canScroll();
        if (!canScroll) {
            this.fxG.scrollTo(0, 0);
        } else {
            int scrollX = this.fxG.getScrollX();
            biI = this.fxG.biI();
            if (scrollX > biI) {
                DragHorizonScrollView dragHorizonScrollView = this.fxG;
                biI2 = this.fxG.biI();
                dragHorizonScrollView.scrollTo(biI2, 0);
            }
        }
        z = this.fxG.fxC;
        if (z) {
            this.fxG.requestLayout();
        }
    }
}
