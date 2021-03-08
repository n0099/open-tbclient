package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class ce implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FeedbackInputActivity feedbackInputActivity) {
        this.f3705a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3705a.t = true;
        this.f3705a.b();
    }
}
