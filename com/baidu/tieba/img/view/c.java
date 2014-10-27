package com.baidu.tieba.img.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView blz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.blz = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean Sd;
        int Se;
        int Se2;
        boolean z;
        this.blz.blu = false;
        int childCount = this.blz.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.blz.getChildAt(i).clearAnimation();
        }
        Sd = this.blz.Sd();
        if (!Sd) {
            this.blz.scrollTo(0, 0);
        } else {
            int scrollX = this.blz.getScrollX();
            Se = this.blz.Se();
            if (scrollX > Se) {
                DragHorizonScrollView dragHorizonScrollView = this.blz;
                Se2 = this.blz.Se();
                dragHorizonScrollView.scrollTo(Se2, 0);
            }
        }
        z = this.blz.blv;
        if (z) {
            this.blz.requestLayout();
        }
    }
}
