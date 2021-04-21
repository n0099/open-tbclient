package com.baidu.ufosdk.ui;

import android.view.KeyEvent;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class be implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22774a;

    public be(FeedbackInputActivity feedbackInputActivity) {
        this.f22774a = feedbackInputActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 4) {
            FeedbackInputActivity.a(this.f22774a);
            return false;
        }
        return false;
    }
}
