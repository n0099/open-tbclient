package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView cpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.cpx = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int anc;
        int anc2;
        boolean z;
        this.cpx.cps = false;
        int childCount = this.cpx.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.cpx.getChildAt(i).clearAnimation();
        }
        canScroll = this.cpx.canScroll();
        if (!canScroll) {
            this.cpx.scrollTo(0, 0);
        } else {
            int scrollX = this.cpx.getScrollX();
            anc = this.cpx.anc();
            if (scrollX > anc) {
                DragHorizonScrollView dragHorizonScrollView = this.cpx;
                anc2 = this.cpx.anc();
                dragHorizonScrollView.scrollTo(anc2, 0);
            }
        }
        z = this.cpx.cpt;
        if (z) {
            this.cpx.requestLayout();
        }
    }
}
