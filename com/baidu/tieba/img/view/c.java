package com.baidu.tieba.img.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView blN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.blN = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean Sg;
        int Sh;
        int Sh2;
        boolean z;
        this.blN.blI = false;
        int childCount = this.blN.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.blN.getChildAt(i).clearAnimation();
        }
        Sg = this.blN.Sg();
        if (!Sg) {
            this.blN.scrollTo(0, 0);
        } else {
            int scrollX = this.blN.getScrollX();
            Sh = this.blN.Sh();
            if (scrollX > Sh) {
                DragHorizonScrollView dragHorizonScrollView = this.blN;
                Sh2 = this.blN.Sh();
                dragHorizonScrollView.scrollTo(Sh2, 0);
            }
        }
        z = this.blN.blJ;
        if (z) {
            this.blN.requestLayout();
        }
    }
}
