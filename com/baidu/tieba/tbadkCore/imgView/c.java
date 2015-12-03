package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView dBd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.dBd = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aDy;
        int aDy2;
        boolean z;
        this.dBd.dAY = false;
        int childCount = this.dBd.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.dBd.getChildAt(i).clearAnimation();
        }
        canScroll = this.dBd.canScroll();
        if (!canScroll) {
            this.dBd.scrollTo(0, 0);
        } else {
            int scrollX = this.dBd.getScrollX();
            aDy = this.dBd.aDy();
            if (scrollX > aDy) {
                DragHorizonScrollView dragHorizonScrollView = this.dBd;
                aDy2 = this.dBd.aDy();
                dragHorizonScrollView.scrollTo(aDy2, 0);
            }
        }
        z = this.dBd.dAZ;
        if (z) {
            this.dBd.requestLayout();
        }
    }
}
