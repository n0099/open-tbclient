package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ al bwq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.bwq = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scroller scroller;
        boolean z;
        View view;
        Scroller scroller2;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        scroller = this.bwq.mScroller;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.bwq.mScroller;
            int currX = scroller2.getCurrX();
            view2 = this.bwq.mView;
            view3 = this.bwq.mView;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.bwq.mView;
            int paddingRight = view4.getPaddingRight();
            view5 = this.bwq.mView;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.bwq.mView;
            view6.invalidate();
            view7 = this.bwq.mView;
            view7.post(this);
            return;
        }
        z = this.bwq.isShow;
        if (!z) {
            view = this.bwq.mView;
            view.setVisibility(8);
        }
    }
}
