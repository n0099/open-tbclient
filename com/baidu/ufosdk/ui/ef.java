package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
/* loaded from: classes8.dex */
final class ef implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(FeedbackReportActivity feedbackReportActivity) {
        this.f5558a = feedbackReportActivity;
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
        z = this.f5558a.E;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f5558a);
            dVar.b(dVar.b() + 1);
            this.f5558a.E = true;
        }
        editText = this.f5558a.u;
        if (editText != null) {
            editText4 = this.f5558a.u;
            if (editText4.getText().toString().trim().length() > 30) {
                editText5 = this.f5558a.u;
                str = this.f5558a.M;
                editText5.setText(str);
                Toast.makeText(this.f5558a, com.baidu.ufosdk.f.s.a("32"), 1).show();
                editText6 = this.f5558a.u;
                str2 = this.f5558a.M;
                editText6.setSelection(str2.length());
            }
        }
        editText2 = this.f5558a.u;
        if (editText2 != null) {
            FeedbackReportActivity feedbackReportActivity = this.f5558a;
            editText3 = this.f5558a.u;
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
