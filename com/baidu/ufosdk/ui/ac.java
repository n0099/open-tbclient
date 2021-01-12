package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FeedbackEditActivity feedbackEditActivity) {
        this.f5425a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f5425a.v;
        if (z) {
            return;
        }
        list = this.f5425a.q;
        if (list.size() >= 2) {
            FeedbackEditActivity.a(this.f5425a, 2);
        }
    }
}
