package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f5436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f5436a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5436a.u = true;
        this.f5436a.c();
    }
}
