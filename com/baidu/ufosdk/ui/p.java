package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23057a;

    public p(FeedbackEditActivity feedbackEditActivity) {
        this.f23057a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.f23057a.v;
        if (z) {
            return;
        }
        list = this.f23057a.q;
        if (list.size() < 2) {
            FeedbackEditActivity feedbackEditActivity = this.f23057a;
            list2 = feedbackEditActivity.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout2 --> to browse picture!");
        hashMap = this.f23057a.r;
        String str = (String) hashMap.get("1");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f23057a, str, 1);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.f23057a;
        list3 = feedbackEditActivity2.q;
        feedbackEditActivity2.a((byte[]) list3.get(1), false, 1);
    }
}
