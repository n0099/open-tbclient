package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView daH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.daH = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int awX;
        int awX2;
        boolean z;
        this.daH.daC = false;
        int childCount = this.daH.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.daH.getChildAt(i).clearAnimation();
        }
        canScroll = this.daH.canScroll();
        if (!canScroll) {
            this.daH.scrollTo(0, 0);
        } else {
            int scrollX = this.daH.getScrollX();
            awX = this.daH.awX();
            if (scrollX > awX) {
                DragHorizonScrollView dragHorizonScrollView = this.daH;
                awX2 = this.daH.awX();
                dragHorizonScrollView.scrollTo(awX2, 0);
            }
        }
        z = this.daH.daD;
        if (z) {
            this.daH.requestLayout();
        }
    }
}
