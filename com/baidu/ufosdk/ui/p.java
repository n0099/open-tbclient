package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class p implements View.OnClickListener {
    final /* synthetic */ FeedbackEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.a.v;
        if (z) {
            return;
        }
        list = this.a.q;
        if (list.size() < 2) {
            FeedbackEditActivity feedbackEditActivity = this.a;
            list2 = this.a.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout2 --> to browse picture!");
        hashMap = this.a.r;
        String str = (String) hashMap.get("1");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.a, str, 1);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.a;
        list3 = this.a.q;
        feedbackEditActivity2.a((byte[]) list3.get(1), false, 1);
    }
}
