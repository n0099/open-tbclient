package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
/* loaded from: classes5.dex */
public final class n implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22972a;

    /* renamed from: b  reason: collision with root package name */
    public long f22973b = 0;

    public n(FeedbackEditActivity feedbackEditActivity) {
        this.f22972a = feedbackEditActivity;
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
        z = this.f22972a.x;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f22972a);
            dVar.b(dVar.b() + 1);
            this.f22972a.x = true;
        }
        try {
            editText = this.f22972a.n;
            if (editText != null) {
                editText4 = this.f22972a.n;
                if (editText4.getText().toString().length() > 30) {
                    if (System.currentTimeMillis() - this.f22973b > 3000) {
                        Toast.makeText(this.f22972a, com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS), 0).show();
                        this.f22973b = System.currentTimeMillis();
                    }
                    editText5 = this.f22972a.n;
                    str = this.f22972a.R;
                    editText5.setText(str);
                    editText6 = this.f22972a.m;
                    editText7 = this.f22972a.n;
                    FeedbackEditActivity.b(editText6, editText7.getText().length());
                }
            }
            editText2 = this.f22972a.n;
            if (editText2 != null) {
                FeedbackEditActivity feedbackEditActivity = this.f22972a;
                editText3 = this.f22972a.n;
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
