package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23293a;

    public q(FeedbackEditActivity feedbackEditActivity) {
        this.f23293a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.f23293a.v;
        if (z) {
            return;
        }
        list = this.f23293a.q;
        if (list.size() < 3) {
            FeedbackEditActivity feedbackEditActivity = this.f23293a;
            list2 = feedbackEditActivity.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout3 --> to browse picture!");
        hashMap = this.f23293a.r;
        String str = (String) hashMap.get("2");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f23293a, str, 2);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.f23293a;
        list3 = feedbackEditActivity2.q;
        feedbackEditActivity2.a((byte[]) list3.get(2), false, 2);
    }
}
