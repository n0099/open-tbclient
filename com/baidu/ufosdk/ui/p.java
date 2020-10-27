package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3883a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedbackEditActivity feedbackEditActivity) {
        this.f3883a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.f3883a.v;
        if (z) {
            return;
        }
        list = this.f3883a.q;
        if (list.size() < 2) {
            FeedbackEditActivity feedbackEditActivity = this.f3883a;
            list2 = this.f3883a.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout2 --> to browse picture!");
        hashMap = this.f3883a.r;
        String str = (String) hashMap.get("1");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f3883a, str, 1);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.f3883a;
        list3 = this.f3883a.q;
        feedbackEditActivity2.a((byte[]) list3.get(1), false, 1);
    }
}
