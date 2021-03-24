package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23290a;

    public o(FeedbackEditActivity feedbackEditActivity) {
        this.f23290a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        HashMap hashMap;
        List list2;
        z = this.f23290a.v;
        if (z) {
            return;
        }
        list = this.f23290a.q;
        if (list.size() <= 0) {
            FeedbackEditActivity.s(this.f23290a);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout1--> to browse picture!");
        hashMap = this.f23290a.r;
        String str = (String) hashMap.get("0");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f23290a, str, 0);
            return;
        }
        FeedbackEditActivity feedbackEditActivity = this.f23290a;
        list2 = feedbackEditActivity.q;
        feedbackEditActivity.a((byte[]) list2.get(0), false, 0);
    }
}
