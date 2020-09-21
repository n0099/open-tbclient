package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class am implements View.OnClickListener {
    final /* synthetic */ FeedbackFacePageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.u = true;
        this.a.c();
    }
}
