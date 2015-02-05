package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView cae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.cae = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int ahM;
        int ahM2;
        boolean z;
        this.cae.bZZ = false;
        int childCount = this.cae.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cae.getChildAt(i).clearAnimation();
        }
        canScroll = this.cae.canScroll();
        if (!canScroll) {
            this.cae.scrollTo(0, 0);
        } else {
            int scrollX = this.cae.getScrollX();
            ahM = this.cae.ahM();
            if (scrollX > ahM) {
                DragHorizonScrollView dragHorizonScrollView = this.cae;
                ahM2 = this.cae.ahM();
                dragHorizonScrollView.scrollTo(ahM2, 0);
            }
        }
        z = this.cae.caa;
        if (z) {
            this.cae.requestLayout();
        }
    }
}
