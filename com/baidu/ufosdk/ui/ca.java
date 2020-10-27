package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f3793a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3793a.D) {
            return;
        }
        if (this.f3793a.p.getVisibility() == 0) {
            this.f3793a.p.setVisibility(8);
            this.f3793a.C.setVisibility(8);
            return;
        }
        if (this.f3793a.p.getChildCount() <= 0) {
            this.f3793a.a(true);
        }
        this.f3793a.p.setVisibility(0);
        this.f3793a.C.setVisibility(0);
    }
}
