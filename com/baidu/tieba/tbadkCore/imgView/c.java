package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView cKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.cKb = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aqo;
        int aqo2;
        boolean z;
        this.cKb.cJW = false;
        int childCount = this.cKb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cKb.getChildAt(i).clearAnimation();
        }
        canScroll = this.cKb.canScroll();
        if (!canScroll) {
            this.cKb.scrollTo(0, 0);
        } else {
            int scrollX = this.cKb.getScrollX();
            aqo = this.cKb.aqo();
            if (scrollX > aqo) {
                DragHorizonScrollView dragHorizonScrollView = this.cKb;
                aqo2 = this.cKb.aqo();
                dragHorizonScrollView.scrollTo(aqo2, 0);
            }
        }
        z = this.cKb.cJX;
        if (z) {
            this.cKb.requestLayout();
        }
    }
}
