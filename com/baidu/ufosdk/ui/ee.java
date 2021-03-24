package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class ee implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23207a;

    /* renamed from: b  reason: collision with root package name */
    public int f23208b;

    public ee(FeedbackReportActivity feedbackReportActivity) {
        this.f23207a = feedbackReportActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        EditText editText;
        TextView textView;
        TextView textView2;
        a aVar;
        Button button;
        Button button2;
        a aVar2;
        Button button3;
        Button button4;
        TextView textView3;
        TextView textView4;
        z = this.f23207a.E;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f23207a);
            dVar.b(dVar.b() + 1);
            this.f23207a.E = true;
        }
        editText = this.f23207a.t;
        int length = editText.getText().toString().trim().length();
        if (editable.length() <= 4) {
            textView4 = this.f23207a.v;
            textView4.setText("4-" + com.baidu.ufosdk.b.aa + "字");
        } else {
            textView = this.f23207a.v;
            textView.setText(String.valueOf(editable.length()) + "-" + com.baidu.ufosdk.b.aa + "字");
        }
        if (length > com.baidu.ufosdk.b.aa) {
            textView3 = this.f23207a.v;
            textView3.setTextColor(-568497);
            this.f23207a.H = true;
        } else {
            textView2 = this.f23207a.v;
            textView2.setTextColor(-5131855);
            this.f23207a.H = false;
        }
        int i = this.f23208b;
        if (i == 0) {
            aVar = this.f23207a.U;
            if (aVar.c().size() <= 0) {
                button = this.f23207a.m;
                button.setTextColor(com.baidu.ufosdk.b.y);
                return;
            }
            button2 = this.f23207a.m;
            int i2 = com.baidu.ufosdk.b.v;
            int i3 = com.baidu.ufosdk.b.y;
            int i4 = com.baidu.ufosdk.b.v;
            button2.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
        } else if (i != 1) {
        } else {
            aVar2 = this.f23207a.U;
            if (aVar2.c().size() <= 0) {
                button3 = this.f23207a.m;
                button3.setTextColor(com.baidu.ufosdk.b.y);
                return;
            }
            button4 = this.f23207a.m;
            int i5 = com.baidu.ufosdk.b.v;
            int i6 = com.baidu.ufosdk.b.y;
            int i7 = com.baidu.ufosdk.b.v;
            button4.setTextColor(com.baidu.ufosdk.f.i.a(i5, i6, i7, i7));
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        editText = this.f23207a.t;
        this.f23208b = editText.getText().toString().trim().length() < 4 ? 0 : 1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
