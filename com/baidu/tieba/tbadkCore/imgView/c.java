package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView cph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.cph = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int amN;
        int amN2;
        boolean z;
        this.cph.cpc = false;
        int childCount = this.cph.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cph.getChildAt(i).clearAnimation();
        }
        canScroll = this.cph.canScroll();
        if (!canScroll) {
            this.cph.scrollTo(0, 0);
        } else {
            int scrollX = this.cph.getScrollX();
            amN = this.cph.amN();
            if (scrollX > amN) {
                DragHorizonScrollView dragHorizonScrollView = this.cph;
                amN2 = this.cph.amN();
                dragHorizonScrollView.scrollTo(amN2, 0);
            }
        }
        z = this.cph.cpd;
        if (z) {
            this.cph.requestLayout();
        }
    }
}
