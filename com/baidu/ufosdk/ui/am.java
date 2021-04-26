package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f23464a;

    public am(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f23464a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f23464a.u = true;
        this.f23464a.c();
    }
}
