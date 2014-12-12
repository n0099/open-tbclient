package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView bYm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.bYm = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int ahn;
        int ahn2;
        boolean z;
        this.bYm.bYh = false;
        int childCount = this.bYm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.bYm.getChildAt(i).clearAnimation();
        }
        canScroll = this.bYm.canScroll();
        if (!canScroll) {
            this.bYm.scrollTo(0, 0);
        } else {
            int scrollX = this.bYm.getScrollX();
            ahn = this.bYm.ahn();
            if (scrollX > ahn) {
                DragHorizonScrollView dragHorizonScrollView = this.bYm;
                ahn2 = this.bYm.ahn();
                dragHorizonScrollView.scrollTo(ahn2, 0);
            }
        }
        z = this.bYm.bYi;
        if (z) {
            this.bYm.requestLayout();
        }
    }
}
