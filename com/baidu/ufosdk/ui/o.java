package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FeedbackEditActivity feedbackEditActivity) {
        this.f3790a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        HashMap hashMap;
        List list2;
        z = this.f3790a.v;
        if (z) {
            return;
        }
        list = this.f3790a.q;
        if (list.size() <= 0) {
            FeedbackEditActivity.s(this.f3790a);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout1--> to browse picture!");
        hashMap = this.f3790a.r;
        String str = (String) hashMap.get("0");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f3790a, str, 0);
            return;
        }
        FeedbackEditActivity feedbackEditActivity = this.f3790a;
        list2 = this.f3790a.q;
        feedbackEditActivity.a((byte[]) list2.get(0), false, 0);
    }
}
