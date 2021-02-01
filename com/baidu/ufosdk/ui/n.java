package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.IMConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class n implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5606a;

    /* renamed from: b  reason: collision with root package name */
    private long f5607b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FeedbackEditActivity feedbackEditActivity) {
        this.f5606a = feedbackEditActivity;
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
        z = this.f5606a.x;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f5606a);
            dVar.b(dVar.b() + 1);
            this.f5606a.x = true;
        }
        try {
            editText = this.f5606a.n;
            if (editText != null) {
                editText4 = this.f5606a.n;
                if (editText4.getText().toString().length() > 30) {
                    if (System.currentTimeMillis() - this.f5607b > IMConnection.RETRY_DELAY_TIMES) {
                        Toast.makeText(this.f5606a, com.baidu.ufosdk.f.s.a("32"), 0).show();
                        this.f5607b = System.currentTimeMillis();
                    }
                    editText5 = this.f5606a.n;
                    str = this.f5606a.R;
                    editText5.setText(str);
                    editText6 = this.f5606a.m;
                    editText7 = this.f5606a.n;
                    FeedbackEditActivity.b(editText6, editText7.getText().length());
                }
            }
            editText2 = this.f5606a.n;
            if (editText2 != null) {
                FeedbackEditActivity feedbackEditActivity = this.f5606a;
                editText3 = this.f5606a.n;
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
