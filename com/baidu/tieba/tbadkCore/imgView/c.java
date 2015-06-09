package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.ctz = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aoU;
        int aoU2;
        boolean z;
        this.ctz.ctu = false;
        int childCount = this.ctz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.ctz.getChildAt(i).clearAnimation();
        }
        canScroll = this.ctz.canScroll();
        if (!canScroll) {
            this.ctz.scrollTo(0, 0);
        } else {
            int scrollX = this.ctz.getScrollX();
            aoU = this.ctz.aoU();
            if (scrollX > aoU) {
                DragHorizonScrollView dragHorizonScrollView = this.ctz;
                aoU2 = this.ctz.aoU();
                dragHorizonScrollView.scrollTo(aoU2, 0);
            }
        }
        z = this.ctz.ctv;
        if (z) {
            this.ctz.requestLayout();
        }
    }
}
