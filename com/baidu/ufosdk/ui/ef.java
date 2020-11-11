package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
/* loaded from: classes22.dex */
final class ef implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3853a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(FeedbackReportActivity feedbackReportActivity) {
        this.f3853a = feedbackReportActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        String str;
        EditText editText6;
        String str2;
        z = this.f3853a.E;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f3853a);
            dVar.b(dVar.b() + 1);
            this.f3853a.E = true;
        }
        editText = this.f3853a.u;
        if (editText != null) {
            editText4 = this.f3853a.u;
            if (editText4.getText().toString().trim().length() > 30) {
                editText5 = this.f3853a.u;
                str = this.f3853a.M;
                editText5.setText(str);
                Toast.makeText(this.f3853a, com.baidu.ufosdk.f.s.a("32"), 1).show();
                editText6 = this.f3853a.u;
                str2 = this.f3853a.M;
                editText6.setSelection(str2.length());
            }
        }
        editText2 = this.f3853a.u;
        if (editText2 != null) {
            FeedbackReportActivity feedbackReportActivity = this.f3853a;
            editText3 = this.f3853a.u;
            feedbackReportActivity.M = editText3.getText().toString();
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
