package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class ce implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FeedbackInputActivity feedbackInputActivity) {
        this.f3802a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3802a.t = true;
        this.f3802a.b();
    }
}
