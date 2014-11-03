package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am bsT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bsT = amVar;
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
        scroller = this.bsT.mScroller;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.bsT.mScroller;
            int currX = scroller2.getCurrX();
            view2 = this.bsT.mView;
            view3 = this.bsT.mView;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.bsT.mView;
            int paddingRight = view4.getPaddingRight();
            view5 = this.bsT.mView;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.bsT.mView;
            view6.invalidate();
            view7 = this.bsT.mView;
            view7.post(this);
            return;
        }
        z = this.bsT.iC;
        if (!z) {
            view = this.bsT.mView;
            view.setVisibility(8);
        }
    }
}
