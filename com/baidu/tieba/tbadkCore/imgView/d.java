package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fzW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fzW = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bjJ;
        int bjJ2;
        boolean z;
        this.fzW.fzR = false;
        int childCount = this.fzW.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fzW.getChildAt(i).clearAnimation();
        }
        canScroll = this.fzW.canScroll();
        if (!canScroll) {
            this.fzW.scrollTo(0, 0);
        } else {
            int scrollX = this.fzW.getScrollX();
            bjJ = this.fzW.bjJ();
            if (scrollX > bjJ) {
                DragHorizonScrollView dragHorizonScrollView = this.fzW;
                bjJ2 = this.fzW.bjJ();
                dragHorizonScrollView.scrollTo(bjJ2, 0);
            }
        }
        z = this.fzW.fzS;
        if (z) {
            this.fzW.requestLayout();
        }
    }
}
