package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fvW = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bhX;
        int bhX2;
        boolean z;
        this.fvW.fvR = false;
        int childCount = this.fvW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fvW.getChildAt(i).clearAnimation();
        }
        canScroll = this.fvW.canScroll();
        if (!canScroll) {
            this.fvW.scrollTo(0, 0);
        } else {
            int scrollX = this.fvW.getScrollX();
            bhX = this.fvW.bhX();
            if (scrollX > bhX) {
                DragHorizonScrollView dragHorizonScrollView = this.fvW;
                bhX2 = this.fvW.bhX();
                dragHorizonScrollView.scrollTo(bhX2, 0);
            }
        }
        z = this.fvW.fvS;
        if (z) {
            this.fvW.requestLayout();
        }
    }
}
