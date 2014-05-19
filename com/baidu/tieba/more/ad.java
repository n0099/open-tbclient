package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
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
        scroller = this.a.b;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.a.b;
            int currX = scroller2.getCurrX();
            view2 = this.a.a;
            view3 = this.a.a;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.a.a;
            int paddingRight = view4.getPaddingRight();
            view5 = this.a.a;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.a.a;
            view6.invalidate();
            view7 = this.a.a;
            view7.post(this);
            return;
        }
        z = this.a.f;
        if (!z) {
            view = this.a.a;
            view.setVisibility(8);
        }
    }
}
