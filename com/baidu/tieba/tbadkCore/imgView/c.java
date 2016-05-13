package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView euH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.euH = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aUx;
        int aUx2;
        boolean z;
        this.euH.euC = false;
        int childCount = this.euH.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.euH.getChildAt(i).clearAnimation();
        }
        canScroll = this.euH.canScroll();
        if (!canScroll) {
            this.euH.scrollTo(0, 0);
        } else {
            int scrollX = this.euH.getScrollX();
            aUx = this.euH.aUx();
            if (scrollX > aUx) {
                DragHorizonScrollView dragHorizonScrollView = this.euH;
                aUx2 = this.euH.aUx();
                dragHorizonScrollView.scrollTo(aUx2, 0);
            }
        }
        z = this.euH.euD;
        if (z) {
            this.euH.requestLayout();
        }
    }
}
