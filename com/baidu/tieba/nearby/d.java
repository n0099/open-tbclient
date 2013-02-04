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
        View t;
        Handler handler;
        AbsoluteLayout absoluteLayout;
        boolean z;
        int b;
        AbsoluteLayout absoluteLayout2;
        View view;
        super.handleMessage(message);
        if (message.what != 1) {
            if (message.what == 2) {
                t = this.a.t();
                if (t != null) {
                    this.a.r();
                    return;
                }
                return;
            }
            return;
        }
        handler = this.a.z;
        handler.removeMessages(1);
        absoluteLayout = this.a.c;
        int childCount = absoluteLayout.getChildCount();
        z = this.a.A;
        if (!z || childCount <= 1) {
            return;
        }
        b = this.a.b(childCount - 1);
        absoluteLayout2 = this.a.c;
        View childAt = absoluteLayout2.getChildAt(b + 1);
        view = this.a.q;
        if (childAt == view || childAt.getVisibility() != 0) {
            return;
        }
        this.a.a(childAt);
    }
}
