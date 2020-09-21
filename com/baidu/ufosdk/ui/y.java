package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class y implements View.OnClickListener {
    final /* synthetic */ FeedbackEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c();
    }
}
