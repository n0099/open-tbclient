package com.baidu.tieba.nearby;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AbsoluteLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ LbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LbsActivity lbsActivity) {
        this.a = lbsActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        View v;
        Handler handler;
        AbsoluteLayout absoluteLayout;
        boolean z;
        int d;
        AbsoluteLayout absoluteLayout2;
        View view;
        super.handleMessage(message);
        if (message.what == 1) {
            handler = this.a.A;
            handler.removeMessages(1);
            absoluteLayout = this.a.d;
            int childCount = absoluteLayout.getChildCount();
            z = this.a.B;
            if (!z || childCount <= 1) {
                return;
            }
            d = this.a.d(childCount - 1);
            absoluteLayout2 = this.a.d;
            View childAt = absoluteLayout2.getChildAt(d + 1);
            view = this.a.r;
            if (childAt != view && childAt.getVisibility() == 0) {
                this.a.a(childAt);
            }
        } else if (message.what != 2) {
        } else {
            v = this.a.v();
            if (v == null) {
                return;
            }
            this.a.t();
        }
    }
}
