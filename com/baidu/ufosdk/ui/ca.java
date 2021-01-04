package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f5765a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5765a.D) {
            return;
        }
        if (this.f5765a.p.getVisibility() == 0) {
            this.f5765a.p.setVisibility(8);
            this.f5765a.C.setVisibility(8);
            return;
        }
        if (this.f5765a.p.getChildCount() <= 0) {
            this.f5765a.a(true);
        }
        this.f5765a.p.setVisibility(0);
        this.f5765a.C.setVisibility(0);
    }
}
