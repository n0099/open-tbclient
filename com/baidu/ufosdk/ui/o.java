package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23056a;

    public o(FeedbackEditActivity feedbackEditActivity) {
        this.f23056a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        HashMap hashMap;
        List list2;
        z = this.f23056a.v;
        if (z) {
            return;
        }
        list = this.f23056a.q;
        if (list.size() <= 0) {
            FeedbackEditActivity.s(this.f23056a);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout1--> to browse picture!");
        hashMap = this.f23056a.r;
        String str = (String) hashMap.get("0");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f23056a, str, 0);
            return;
        }
        FeedbackEditActivity feedbackEditActivity = this.f23056a;
        list2 = feedbackEditActivity.q;
        feedbackEditActivity.a((byte[]) list2.get(0), false, 0);
    }
}
