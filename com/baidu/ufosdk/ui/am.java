package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f3659a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f3659a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3659a.u = true;
        this.f3659a.c();
    }
}
