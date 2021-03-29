package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bt implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23098a;

    public bt(FeedbackInputActivity feedbackInputActivity) {
        this.f23098a = feedbackInputActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        z = this.f23098a.au;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f23098a);
            dVar.b(dVar.b() + 1);
            this.f23098a.au = true;
        }
        FeedbackInputActivity feedbackInputActivity = this.f23098a;
        int i = feedbackInputActivity.I;
        if (i != 0) {
            if (i == 1 && feedbackInputActivity.E.getText().toString().trim().length() <= 0) {
                this.f23098a.J.setTextColor(com.baidu.ufosdk.b.y);
            }
        } else if (feedbackInputActivity.E.getText().toString().trim().length() > 0) {
            TextView textView = this.f23098a.J;
            int i2 = com.baidu.ufosdk.b.v;
            int i3 = com.baidu.ufosdk.b.y;
            int i4 = com.baidu.ufosdk.b.v;
            textView.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        FeedbackInputActivity feedbackInputActivity;
        int i4;
        if (this.f23098a.E.getText().toString().trim().length() <= 0) {
            feedbackInputActivity = this.f23098a;
            i4 = 0;
        } else {
            feedbackInputActivity = this.f23098a;
            i4 = 1;
        }
        feedbackInputActivity.I = i4;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
