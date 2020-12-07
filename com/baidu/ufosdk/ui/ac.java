package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3746a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FeedbackEditActivity feedbackEditActivity) {
        this.f3746a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f3746a.v;
        if (z) {
            return;
        }
        list = this.f3746a.q;
        if (list.size() >= 2) {
            FeedbackEditActivity.a(this.f3746a, 2);
        }
    }
}
