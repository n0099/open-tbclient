package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView cSB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.cSB = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int auC;
        int auC2;
        boolean z;
        this.cSB.cSw = false;
        int childCount = this.cSB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cSB.getChildAt(i).clearAnimation();
        }
        canScroll = this.cSB.canScroll();
        if (!canScroll) {
            this.cSB.scrollTo(0, 0);
        } else {
            int scrollX = this.cSB.getScrollX();
            auC = this.cSB.auC();
            if (scrollX > auC) {
                DragHorizonScrollView dragHorizonScrollView = this.cSB;
                auC2 = this.cSB.auC();
                dragHorizonScrollView.scrollTo(auC2, 0);
            }
        }
        z = this.cSB.cSx;
        if (z) {
            this.cSB.requestLayout();
        }
    }
}
