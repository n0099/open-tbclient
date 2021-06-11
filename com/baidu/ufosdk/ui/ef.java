package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
/* loaded from: classes5.dex */
public final class ef implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22891a;

    public ef(FeedbackReportActivity feedbackReportActivity) {
        this.f22891a = feedbackReportActivity;
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
        z = this.f22891a.E;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f22891a);
            dVar.b(dVar.b() + 1);
            this.f22891a.E = true;
        }
        editText = this.f22891a.u;
        if (editText != null) {
            editText4 = this.f22891a.u;
            if (editText4.getText().toString().trim().length() > 30) {
                editText5 = this.f22891a.u;
                str = this.f22891a.M;
                editText5.setText(str);
                Toast.makeText(this.f22891a, com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS), 1).show();
                editText6 = this.f22891a.u;
                str2 = this.f22891a.M;
                editText6.setSelection(str2.length());
            }
        }
        editText2 = this.f22891a.u;
        if (editText2 != null) {
            FeedbackReportActivity feedbackReportActivity = this.f22891a;
            editText3 = feedbackReportActivity.u;
            feedbackReportActivity.M = editText3.getText().toString();
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
