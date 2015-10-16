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
        int axb;
        int axb2;
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
            axb = this.daH.axb();
            if (scrollX > axb) {
                DragHorizonScrollView dragHorizonScrollView = this.daH;
                axb2 = this.daH.axb();
                dragHorizonScrollView.scrollTo(axb2, 0);
            }
        }
        z = this.daH.daD;
        if (z) {
            this.daH.requestLayout();
        }
    }
}
