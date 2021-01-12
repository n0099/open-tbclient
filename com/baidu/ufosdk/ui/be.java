package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes7.dex */
final class be implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(FeedbackInputActivity feedbackInputActivity) {
        this.f5456a = feedbackInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            FeedbackInputActivity.a(this.f5456a);
            return false;
        }
        return false;
    }
}
