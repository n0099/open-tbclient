package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class be implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23484a;

    public be(FeedbackInputActivity feedbackInputActivity) {
        this.f23484a = feedbackInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            FeedbackInputActivity.a(this.f23484a);
            return false;
        }
        return false;
    }
}
