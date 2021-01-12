package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.HashMap;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedbackEditActivity feedbackEditActivity) {
        this.f5608a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        z = this.f5608a.v;
        if (z) {
            return;
        }
        list = this.f5608a.q;
        if (list.size() < 3) {
            FeedbackEditActivity feedbackEditActivity = this.f5608a;
            list2 = this.f5608a.q;
            list2.size();
            FeedbackEditActivity.s(feedbackEditActivity);
            return;
        }
        com.baidu.ufosdk.f.c.a("picShotLayout3 --> to browse picture!");
        hashMap = this.f5608a.r;
        String str = (String) hashMap.get("2");
        if (str != null && str.length() != 0) {
            FeedbackEditActivity.a(this.f5608a, str, 2);
            return;
        }
        FeedbackEditActivity feedbackEditActivity2 = this.f5608a;
        list3 = this.f5608a.q;
        feedbackEditActivity2.a((byte[]) list3.get(2), false, 2);
    }
}
