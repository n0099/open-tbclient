package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ad implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FeedbackEditActivity feedbackEditActivity) {
        this.f5709a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f5709a.v;
        if (z) {
            return;
        }
        list = this.f5709a.q;
        if (list.size() >= 3) {
            FeedbackEditActivity.a(this.f5709a, 3);
        }
    }
}
