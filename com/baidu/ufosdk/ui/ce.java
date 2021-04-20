package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class ce implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22798a;

    public ce(FeedbackInputActivity feedbackInputActivity) {
        this.f22798a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedbackInputActivity feedbackInputActivity = this.f22798a;
        feedbackInputActivity.t = true;
        feedbackInputActivity.b();
    }
}
