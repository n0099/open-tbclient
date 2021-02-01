package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5428a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FeedbackEditActivity feedbackEditActivity) {
        this.f5428a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f5428a.v;
        if (z) {
            return;
        }
        list = this.f5428a.q;
        if (list.size() >= 3) {
            FeedbackEditActivity.a(this.f5428a, 3);
        }
    }
}
