package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView dcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.dcp = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int axN;
        int axN2;
        boolean z;
        this.dcp.dck = false;
        int childCount = this.dcp.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.dcp.getChildAt(i).clearAnimation();
        }
        canScroll = this.dcp.canScroll();
        if (!canScroll) {
            this.dcp.scrollTo(0, 0);
        } else {
            int scrollX = this.dcp.getScrollX();
            axN = this.dcp.axN();
            if (scrollX > axN) {
                DragHorizonScrollView dragHorizonScrollView = this.dcp;
                axN2 = this.dcp.axN();
                dragHorizonScrollView.scrollTo(axN2, 0);
            }
        }
        z = this.dcp.dcl;
        if (z) {
            this.dcp.requestLayout();
        }
    }
}
