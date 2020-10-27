package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f3751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f3751a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3751a.u = true;
        this.f3751a.c();
    }
}
