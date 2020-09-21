package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes21.dex */
final class be implements TextView.OnEditorActionListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            FeedbackInputActivity.a(this.a);
            return false;
        }
        return false;
    }
}
