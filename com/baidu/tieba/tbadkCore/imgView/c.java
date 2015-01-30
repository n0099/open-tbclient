package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView caf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.caf = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int ahR;
        int ahR2;
        boolean z;
        this.caf.caa = false;
        int childCount = this.caf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.caf.getChildAt(i).clearAnimation();
        }
        canScroll = this.caf.canScroll();
        if (!canScroll) {
            this.caf.scrollTo(0, 0);
        } else {
            int scrollX = this.caf.getScrollX();
            ahR = this.caf.ahR();
            if (scrollX > ahR) {
                DragHorizonScrollView dragHorizonScrollView = this.caf;
                ahR2 = this.caf.ahR();
                dragHorizonScrollView.scrollTo(ahR2, 0);
            }
        }
        z = this.caf.cab;
        if (z) {
            this.caf.requestLayout();
        }
    }
}
