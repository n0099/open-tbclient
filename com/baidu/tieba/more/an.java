package com.baidu.tieba.more;

import android.view.View;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f1981a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.f1981a = amVar;
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
        scroller = this.f1981a.b;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.f1981a.b;
            int currX = scroller2.getCurrX();
            view2 = this.f1981a.f1980a;
            view3 = this.f1981a.f1980a;
            int paddingLeft = view3.getPaddingLeft();
            view4 = this.f1981a.f1980a;
            int paddingRight = view4.getPaddingRight();
            view5 = this.f1981a.f1980a;
            view2.setPadding(paddingLeft, currX, paddingRight, view5.getPaddingBottom());
            view6 = this.f1981a.f1980a;
            view6.invalidate();
            view7 = this.f1981a.f1980a;
            view7.post(this);
            return;
        }
        z = this.f1981a.f;
        if (!z) {
            view = this.f1981a.f1980a;
            view.setVisibility(8);
        }
    }
}
