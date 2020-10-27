package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedbackEditActivity feedbackEditActivity) {
        this.f3884a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.f3884a.v;
        if (z) {
            return;
        }
        list = this.f3884a.q;
        if (list.size() < 3) {
            FeedbackEditActivity feedbackEditActivity = this.f3884a;
            list2 = this.f3884a.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout3 --> to browse picture!");
        hashMap = this.f3884a.r;
        String str = (String) hashMap.get("2");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f3884a, str, 2);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.f3884a;
        list3 = this.f3884a.q;
        feedbackEditActivity2.a((byte[]) list3.get(2), false, 2);
    }
}
