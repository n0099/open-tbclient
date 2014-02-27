package com.baidu.tieba.img.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {
    final /* synthetic */ DragHorizonScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(DragHorizonScrollView dragHorizonScrollView) {
        this.a = dragHorizonScrollView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean g;
        int h;
        int h2;
        boolean z;
        this.a.E = false;
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.a.getChildAt(i).clearAnimation();
        }
        g = this.a.g();
        if (!g) {
            this.a.scrollTo(0, 0);
        } else {
            int scrollX = this.a.getScrollX();
            h = this.a.h();
            if (scrollX > h) {
                DragHorizonScrollView dragHorizonScrollView = this.a;
                h2 = this.a.h();
                dragHorizonScrollView.scrollTo(h2, 0);
            }
        }
        z = this.a.F;
        if (z) {
            this.a.requestLayout();
        }
    }
}
