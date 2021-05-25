package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class bz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22683a;

    public bz(FeedbackInputActivity feedbackInputActivity) {
        this.f22683a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        FeedbackInputActivity.a(this.f22683a);
    }
}
