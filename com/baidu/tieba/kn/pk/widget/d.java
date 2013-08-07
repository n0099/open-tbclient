package com.baidu.tieba.kn.pk.widget;

import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f1234a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scroller scroller;
        LinearLayout linearLayout;
        Scroller scroller2;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        Handler handler;
        scroller = this.f1234a.f;
        if (!scroller.computeScrollOffset()) {
            linearLayout = this.f1234a.c;
            linearLayout.setVisibility(8);
            this.f1234a.h = false;
            return;
        }
        scroller2 = this.f1234a.f;
        int currY = scroller2.getCurrY();
        linearLayout2 = this.f1234a.c;
        linearLayout3 = this.f1234a.c;
        int paddingLeft = linearLayout3.getPaddingLeft();
        linearLayout4 = this.f1234a.c;
        int paddingRight = linearLayout4.getPaddingRight();
        linearLayout5 = this.f1234a.c;
        linearLayout2.setPadding(paddingLeft, currY, paddingRight, linearLayout5.getPaddingBottom());
        handler = this.f1234a.g;
        handler.post(this);
    }
}
