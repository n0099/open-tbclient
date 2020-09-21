package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes21.dex */
final class bt implements TextWatcher {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        z = this.a.au;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.a);
            dVar.b(dVar.b() + 1);
            this.a.au = true;
        }
        switch (this.a.I) {
            case 0:
                if (this.a.E.getText().toString().trim().length() > 0) {
                    this.a.J.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                    return;
                }
                return;
            case 1:
                if (this.a.E.getText().toString().trim().length() <= 0) {
                    this.a.J.setTextColor(com.baidu.ufosdk.b.y);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.E.getText().toString().trim().length() <= 0) {
            this.a.I = 0;
        } else {
            this.a.I = 1;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
