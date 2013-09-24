package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f1482a = akVar;
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
        scroller = this.f1482a.b;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.f1482a.b;
            int currX = scroller2.getCurrX();
            view2 = this.f1482a.f1481a;
            view3 = this.f1482a.f1481a;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.f1482a.f1481a;
            int paddingRight = view4.getPaddingRight();
            view5 = this.f1482a.f1481a;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.f1482a.f1481a;
            view6.invalidate();
            view7 = this.f1482a.f1481a;
            view7.post(this);
            return;
        }
        z = this.f1482a.f;
        if (!z) {
            view = this.f1482a.f1481a;
            view.setVisibility(8);
        }
    }
}
