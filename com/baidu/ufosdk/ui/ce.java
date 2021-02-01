package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class ce implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5489a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FeedbackInputActivity feedbackInputActivity) {
        this.f5489a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5489a.t = true;
        this.f5489a.b();
    }
}
