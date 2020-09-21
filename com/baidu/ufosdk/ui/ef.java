package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
/* loaded from: classes21.dex */
final class ef implements TextWatcher {
    final /* synthetic */ FeedbackReportActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(FeedbackReportActivity feedbackReportActivity) {
        this.a = feedbackReportActivity;
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
        z = this.a.E;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.a);
            dVar.b(dVar.b() + 1);
            this.a.E = true;
        }
        editText = this.a.u;
        if (editText != null) {
            editText4 = this.a.u;
            if (editText4.getText().toString().trim().length() > 30) {
                editText5 = this.a.u;
                str = this.a.M;
                editText5.setText(str);
                Toast.makeText(this.a, com.baidu.ufosdk.f.s.a("32"), 1).show();
                editText6 = this.a.u;
                str2 = this.a.M;
                editText6.setSelection(str2.length());
            }
        }
        editText2 = this.a.u;
        if (editText2 != null) {
            FeedbackReportActivity feedbackReportActivity = this.a;
            editText3 = this.a.u;
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
