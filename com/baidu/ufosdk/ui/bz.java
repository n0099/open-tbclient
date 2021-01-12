package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class bz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5480a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(FeedbackInputActivity feedbackInputActivity) {
        this.f5480a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        FeedbackInputActivity.a(this.f5480a);
    }
}
