package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class n implements TextWatcher {
    final /* synthetic */ FeedbackEditActivity a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
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
        EditText editText7;
        z = this.a.x;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.a);
            dVar.b(dVar.b() + 1);
            this.a.x = true;
        }
        try {
            editText = this.a.n;
            if (editText != null) {
                editText4 = this.a.n;
                if (editText4.getText().toString().length() > 30) {
                    if (System.currentTimeMillis() - this.b > IMConnection.RETRY_DELAY_TIMES) {
                        Toast.makeText(this.a, com.baidu.ufosdk.f.s.a("32"), 0).show();
                        this.b = System.currentTimeMillis();
                    }
                    editText5 = this.a.n;
                    str = this.a.R;
                    editText5.setText(str);
                    editText6 = this.a.m;
                    editText7 = this.a.n;
                    FeedbackEditActivity.b(editText6, editText7.getText().length());
                }
            }
            editText2 = this.a.n;
            if (editText2 != null) {
                FeedbackEditActivity feedbackEditActivity = this.a;
                editText3 = this.a.n;
                feedbackEditActivity.R = editText3.getText().toString().trim();
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("联系方式输入有误", e);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
