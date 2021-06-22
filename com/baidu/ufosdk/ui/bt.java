package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class bt implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22860a;

    public bt(FeedbackInputActivity feedbackInputActivity) {
        this.f22860a = feedbackInputActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        z = this.f22860a.au;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f22860a);
            dVar.b(dVar.b() + 1);
            this.f22860a.au = true;
        }
        FeedbackInputActivity feedbackInputActivity = this.f22860a;
        int i2 = feedbackInputActivity.I;
        if (i2 != 0) {
            if (i2 == 1 && feedbackInputActivity.E.getText().toString().trim().length() <= 0) {
                this.f22860a.J.setTextColor(com.baidu.ufosdk.b.y);
            }
        } else if (feedbackInputActivity.E.getText().toString().trim().length() > 0) {
            TextView textView = this.f22860a.J;
            int i3 = com.baidu.ufosdk.b.v;
            int i4 = com.baidu.ufosdk.b.y;
            int i5 = com.baidu.ufosdk.b.v;
            textView.setTextColor(com.baidu.ufosdk.f.i.a(i3, i4, i5, i5));
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        FeedbackInputActivity feedbackInputActivity;
        int i5;
        if (this.f22860a.E.getText().toString().trim().length() <= 0) {
            feedbackInputActivity = this.f22860a;
            i5 = 0;
        } else {
            feedbackInputActivity = this.f22860a;
            i5 = 1;
        }
        feedbackInputActivity.I = i5;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
