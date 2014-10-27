package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ am bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.bsF = amVar;
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
        scroller = this.bsF.mScroller;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.bsF.mScroller;
            int currX = scroller2.getCurrX();
            view2 = this.bsF.mView;
            view3 = this.bsF.mView;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.bsF.mView;
            int paddingRight = view4.getPaddingRight();
            view5 = this.bsF.mView;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.bsF.mView;
            view6.invalidate();
            view7 = this.bsF.mView;
            view7.post(this);
            return;
        }
        z = this.bsF.iC;
        if (!z) {
            view = this.bsF.mView;
            view.setVisibility(8);
        }
    }
}
