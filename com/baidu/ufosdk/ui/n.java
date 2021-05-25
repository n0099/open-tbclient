package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
/* loaded from: classes5.dex */
public final class n implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22869a;

    /* renamed from: b  reason: collision with root package name */
    public long f22870b = 0;

    public n(FeedbackEditActivity feedbackEditActivity) {
        this.f22869a = feedbackEditActivity;
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
        z = this.f22869a.x;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f22869a);
            dVar.b(dVar.b() + 1);
            this.f22869a.x = true;
        }
        try {
            editText = this.f22869a.n;
            if (editText != null) {
                editText4 = this.f22869a.n;
                if (editText4.getText().toString().length() > 30) {
                    if (System.currentTimeMillis() - this.f22870b > 3000) {
                        Toast.makeText(this.f22869a, com.baidu.ufosdk.f.s.a("32"), 0).show();
                        this.f22870b = System.currentTimeMillis();
                    }
                    editText5 = this.f22869a.n;
                    str = this.f22869a.R;
                    editText5.setText(str);
                    editText6 = this.f22869a.m;
                    editText7 = this.f22869a.n;
                    FeedbackEditActivity.b(editText6, editText7.getText().length());
                }
            }
            editText2 = this.f22869a.n;
            if (editText2 != null) {
                FeedbackEditActivity feedbackEditActivity = this.f22869a;
                editText3 = this.f22869a.n;
                feedbackEditActivity.R = editText3.getText().toString().trim();
            }
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("联系方式输入有误", e2);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
