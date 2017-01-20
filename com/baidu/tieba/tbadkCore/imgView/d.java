package com.baidu.tieba.tbadkCore.imgView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ DragHorizonScrollView frz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DragHorizonScrollView dragHorizonScrollView) {
        this.frz = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean canScroll;
        int bih;
        int bih2;
        boolean z;
        this.frz.fru = false;
        int childCount = this.frz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.frz.getChildAt(i).clearAnimation();
        }
        canScroll = this.frz.canScroll();
        if (!canScroll) {
            this.frz.scrollTo(0, 0);
        } else {
            int scrollX = this.frz.getScrollX();
            bih = this.frz.bih();
            if (scrollX > bih) {
                DragHorizonScrollView dragHorizonScrollView = this.frz;
                bih2 = this.frz.bih();
                dragHorizonScrollView.scrollTo(bih2, 0);
            }
        }
        z = this.frz.frv;
        if (z) {
            this.frz.requestLayout();
        }
    }
}
