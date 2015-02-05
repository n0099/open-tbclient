package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ ax bya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.bya = axVar;
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
        scroller = this.bya.mScroller;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.bya.mScroller;
            int currX = scroller2.getCurrX();
            view2 = this.bya.mView;
            view3 = this.bya.mView;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.bya.mView;
            int paddingRight = view4.getPaddingRight();
            view5 = this.bya.mView;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.bya.mView;
            view6.invalidate();
            view7 = this.bya.mView;
            view7.post(this);
            return;
        }
        z = this.bya.isShow;
        if (!z) {
            view = this.bya.mView;
            view.setVisibility(8);
        }
    }
}
