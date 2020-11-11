package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes22.dex */
final class bt implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(FeedbackInputActivity feedbackInputActivity) {
        this.f3787a = feedbackInputActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        z = this.f3787a.au;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f3787a);
            dVar.b(dVar.b() + 1);
            this.f3787a.au = true;
        }
        switch (this.f3787a.I) {
            case 0:
                if (this.f3787a.E.getText().toString().trim().length() > 0) {
                    this.f3787a.J.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                    return;
                }
                return;
            case 1:
                if (this.f3787a.E.getText().toString().trim().length() <= 0) {
                    this.f3787a.J.setTextColor(com.baidu.ufosdk.b.y);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3787a.E.getText().toString().trim().length() <= 0) {
            this.f3787a.I = 0;
        } else {
            this.f3787a.I = 1;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
