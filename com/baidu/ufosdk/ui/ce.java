package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class ce implements View.OnClickListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.t = true;
        this.a.b();
    }
}
