package com.baidu.ufosdk.ui;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3649a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FeedbackEditActivity feedbackEditActivity) {
        this.f3649a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        z = this.f3649a.v;
        if (z) {
            return;
        }
        list = this.f3649a.q;
        if (list.size() >= 2) {
            FeedbackEditActivity.a(this.f3649a, 2);
        }
    }
}
