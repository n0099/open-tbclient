package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes8.dex */
final class be implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(FeedbackInputActivity feedbackInputActivity) {
        this.f5738a = feedbackInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            FeedbackInputActivity.a(this.f5738a);
            return false;
        }
        return false;
    }
}
