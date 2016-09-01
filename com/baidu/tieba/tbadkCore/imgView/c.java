package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView fuu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.fuu = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bjB;
        int bjB2;
        boolean z;
        this.fuu.fup = false;
        int childCount = this.fuu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.fuu.getChildAt(i).clearAnimation();
        }
        canScroll = this.fuu.canScroll();
        if (!canScroll) {
            this.fuu.scrollTo(0, 0);
        } else {
            int scrollX = this.fuu.getScrollX();
            bjB = this.fuu.bjB();
            if (scrollX > bjB) {
                DragHorizonScrollView dragHorizonScrollView = this.fuu;
                bjB2 = this.fuu.bjB();
                dragHorizonScrollView.scrollTo(bjB2, 0);
            }
        }
        z = this.fuu.fuq;
        if (z) {
            this.fuu.requestLayout();
        }
    }
}
