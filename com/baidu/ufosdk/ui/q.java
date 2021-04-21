package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22986a;

    public q(FeedbackEditActivity feedbackEditActivity) {
        this.f22986a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.f22986a.v;
        if (z) {
            return;
        }
        list = this.f22986a.q;
        if (list.size() < 3) {
            FeedbackEditActivity feedbackEditActivity = this.f22986a;
            list2 = feedbackEditActivity.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout3 --> to browse picture!");
        hashMap = this.f22986a.r;
        String str = (String) hashMap.get("2");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f22986a, str, 2);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.f22986a;
        list3 = feedbackEditActivity2.q;
        feedbackEditActivity2.a((byte[]) list3.get(2), false, 2);
    }
}
