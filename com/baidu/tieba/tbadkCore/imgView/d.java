package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fEg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fEg = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bmD;
        int bmD2;
        boolean z;
        this.fEg.fEb = false;
        int childCount = this.fEg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fEg.getChildAt(i).clearAnimation();
        }
        canScroll = this.fEg.canScroll();
        if (!canScroll) {
            this.fEg.scrollTo(0, 0);
        } else {
            int scrollX = this.fEg.getScrollX();
            bmD = this.fEg.bmD();
            if (scrollX > bmD) {
                DragHorizonScrollView dragHorizonScrollView = this.fEg;
                bmD2 = this.fEg.bmD();
                dragHorizonScrollView.scrollTo(bmD2, 0);
            }
        }
        z = this.fEg.fEc;
        if (z) {
            this.fEg.requestLayout();
        }
    }
}
