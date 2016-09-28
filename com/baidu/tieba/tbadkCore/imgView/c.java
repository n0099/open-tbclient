package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fxa = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bkn;
        int bkn2;
        boolean z;
        this.fxa.fwV = false;
        int childCount = this.fxa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fxa.getChildAt(i).clearAnimation();
        }
        canScroll = this.fxa.canScroll();
        if (!canScroll) {
            this.fxa.scrollTo(0, 0);
        } else {
            int scrollX = this.fxa.getScrollX();
            bkn = this.fxa.bkn();
            if (scrollX > bkn) {
                DragHorizonScrollView dragHorizonScrollView = this.fxa;
                bkn2 = this.fxa.bkn();
                dragHorizonScrollView.scrollTo(bkn2, 0);
            }
        }
        z = this.fxa.fwW;
        if (z) {
            this.fxa.requestLayout();
        }
    }
}
