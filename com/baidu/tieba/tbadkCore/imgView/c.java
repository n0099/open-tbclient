package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView daf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.daf = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int awR;
        int awR2;
        boolean z;
        this.daf.daa = false;
        int childCount = this.daf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.daf.getChildAt(i).clearAnimation();
        }
        canScroll = this.daf.canScroll();
        if (!canScroll) {
            this.daf.scrollTo(0, 0);
        } else {
            int scrollX = this.daf.getScrollX();
            awR = this.daf.awR();
            if (scrollX > awR) {
                DragHorizonScrollView dragHorizonScrollView = this.daf;
                awR2 = this.daf.awR();
                dragHorizonScrollView.scrollTo(awR2, 0);
            }
        }
        z = this.daf.dab;
        if (z) {
            this.daf.requestLayout();
        }
    }
}
