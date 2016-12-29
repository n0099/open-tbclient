package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView fil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.fil = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bgs;
        int bgs2;
        boolean z;
        this.fil.fig = false;
        int childCount = this.fil.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fil.getChildAt(i).clearAnimation();
        }
        canScroll = this.fil.canScroll();
        if (!canScroll) {
            this.fil.scrollTo(0, 0);
        } else {
            int scrollX = this.fil.getScrollX();
            bgs = this.fil.bgs();
            if (scrollX > bgs) {
                DragHorizonScrollView dragHorizonScrollView = this.fil;
                bgs2 = this.fil.bgs();
                dragHorizonScrollView.scrollTo(bgs2, 0);
            }
        }
        z = this.fil.fih;
        if (z) {
            this.fil.requestLayout();
        }
    }
}
