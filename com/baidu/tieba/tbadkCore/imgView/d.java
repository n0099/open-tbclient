package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fwf = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bhg;
        int bhg2;
        boolean z;
        this.fwf.fvZ = false;
        int childCount = this.fwf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fwf.getChildAt(i).clearAnimation();
        }
        canScroll = this.fwf.canScroll();
        if (!canScroll) {
            this.fwf.scrollTo(0, 0);
        } else {
            int scrollX = this.fwf.getScrollX();
            bhg = this.fwf.bhg();
            if (scrollX > bhg) {
                DragHorizonScrollView dragHorizonScrollView = this.fwf;
                bhg2 = this.fwf.bhg();
                dragHorizonScrollView.scrollTo(bhg2, 0);
            }
        }
        z = this.fwf.fwa;
        if (z) {
            this.fwf.requestLayout();
        }
    }
}
