package com.baidu.tieba.kn.pk.widget;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1300a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1300a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scroller scroller;
        Scroller scroller2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        Handler handler;
        scroller = this.f1300a.f;
        if (scroller.computeScrollOffset()) {
            scroller2 = this.f1300a.f;
            int currY = scroller2.getCurrY();
            linearLayout = this.f1300a.c;
            linearLayout2 = this.f1300a.c;
            int paddingLeft = linearLayout2.getPaddingLeft();
            linearLayout3 = this.f1300a.c;
            int paddingRight = linearLayout3.getPaddingRight();
            linearLayout4 = this.f1300a.c;
            linearLayout.setPadding(paddingLeft, currY, paddingRight, linearLayout4.getPaddingBottom());
            handler = this.f1300a.g;
            handler.postDelayed(this, 16L);
            return;
        }
        this.f1300a.h = false;
    }
}
