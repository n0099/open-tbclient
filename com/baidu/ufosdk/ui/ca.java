package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.f5483a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f5483a.D) {
            return;
        }
        if (this.f5483a.p.getVisibility() == 0) {
            this.f5483a.p.setVisibility(8);
            this.f5483a.C.setVisibility(8);
            return;
        }
        if (this.f5483a.p.getChildCount() <= 0) {
            this.f5483a.a(true);
        }
        this.f5483a.p.setVisibility(0);
        this.f5483a.C.setVisibility(0);
    }
}
