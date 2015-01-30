package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {
    final /* synthetic */ ax byb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.byb = axVar;
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
        scroller = this.byb.mScroller;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.byb.mScroller;
            int currX = scroller2.getCurrX();
            view2 = this.byb.mView;
            view3 = this.byb.mView;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.byb.mView;
            int paddingRight = view4.getPaddingRight();
            view5 = this.byb.mView;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.byb.mView;
            view6.invalidate();
            view7 = this.byb.mView;
            view7.post(this);
            return;
        }
        z = this.byb.isShow;
        if (!z) {
            view = this.byb.mView;
            view.setVisibility(8);
        }
    }
}
