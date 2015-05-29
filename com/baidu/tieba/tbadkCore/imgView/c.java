package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView cty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.cty = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int aoT;
        int aoT2;
        boolean z;
        this.cty.ctt = false;
        int childCount = this.cty.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cty.getChildAt(i).clearAnimation();
        }
        canScroll = this.cty.canScroll();
        if (!canScroll) {
            this.cty.scrollTo(0, 0);
        } else {
            int scrollX = this.cty.getScrollX();
            aoT = this.cty.aoT();
            if (scrollX > aoT) {
                DragHorizonScrollView dragHorizonScrollView = this.cty;
                aoT2 = this.cty.aoT();
                dragHorizonScrollView.scrollTo(aoT2, 0);
            }
        }
        z = this.cty.ctu;
        if (z) {
            this.cty.requestLayout();
        }
    }
}
