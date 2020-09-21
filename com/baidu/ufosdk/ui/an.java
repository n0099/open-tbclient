package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class an implements View.OnClickListener {
    final /* synthetic */ FeedbackFacePageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.a();
    }
}
