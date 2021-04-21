package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22984a;

    public o(FeedbackEditActivity feedbackEditActivity) {
        this.f22984a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        HashMap hashMap;
        List list2;
        z = this.f22984a.v;
        if (z) {
            return;
        }
        list = this.f22984a.q;
        if (list.size() <= 0) {
            FeedbackEditActivity.s(this.f22984a);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout1--> to browse picture!");
        hashMap = this.f22984a.r;
        String str = (String) hashMap.get("0");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f22984a, str, 0);
            return;
        }
        FeedbackEditActivity feedbackEditActivity = this.f22984a;
        list2 = feedbackEditActivity.q;
        feedbackEditActivity.a((byte[]) list2.get(0), false, 0);
    }
}
