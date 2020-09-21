package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class o implements View.OnClickListener {
    final /* synthetic */ FeedbackEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        HashMap hashMap;
        List list2;
        z = this.a.v;
        if (z) {
            return;
        }
        list = this.a.q;
        if (list.size() <= 0) {
            FeedbackEditActivity.s(this.a);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout1--> to browse picture!");
        hashMap = this.a.r;
        String str = (String) hashMap.get("0");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.a, str, 0);
            return;
        }
        FeedbackEditActivity feedbackEditActivity = this.a;
        list2 = this.a.q;
        feedbackEditActivity.a((byte[]) list2.get(0), false, 0);
    }
}
