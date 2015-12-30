package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView dIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.dIG = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aFL;
        int aFL2;
        boolean z;
        this.dIG.dIB = false;
        int childCount = this.dIG.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.dIG.getChildAt(i).clearAnimation();
        }
        canScroll = this.dIG.canScroll();
        if (!canScroll) {
            this.dIG.scrollTo(0, 0);
        } else {
            int scrollX = this.dIG.getScrollX();
            aFL = this.dIG.aFL();
            if (scrollX > aFL) {
                DragHorizonScrollView dragHorizonScrollView = this.dIG;
                aFL2 = this.dIG.aFL();
                dragHorizonScrollView.scrollTo(aFL2, 0);
            }
        }
        z = this.dIG.dIC;
        if (z) {
            this.dIG.requestLayout();
        }
    }
}
