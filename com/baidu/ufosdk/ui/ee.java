package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
final class ee implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5556a;

    /* renamed from: b  reason: collision with root package name */
    private int f5557b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(FeedbackReportActivity feedbackReportActivity) {
        this.f5556a = feedbackReportActivity;
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
        z = this.f5556a.E;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f5556a);
            dVar.b(dVar.b() + 1);
            this.f5556a.E = true;
        }
        editText = this.f5556a.t;
        int length = editText.getText().toString().trim().length();
        if (editable.length() <= 4) {
            textView4 = this.f5556a.v;
            textView4.setText("4-" + com.baidu.ufosdk.b.aa + "字");
        } else {
            textView = this.f5556a.v;
            textView.setText(String.valueOf(editable.length()) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.baidu.ufosdk.b.aa + "字");
        }
        if (length > com.baidu.ufosdk.b.aa) {
            textView3 = this.f5556a.v;
            textView3.setTextColor(-568497);
            this.f5556a.H = true;
        } else {
            textView2 = this.f5556a.v;
            textView2.setTextColor(-5131855);
            this.f5556a.H = false;
        }
        switch (this.f5557b) {
            case 0:
                aVar2 = this.f5556a.U;
                if (aVar2.c().size() > 0) {
                    button4 = this.f5556a.m;
                    button4.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                    return;
                }
                button3 = this.f5556a.m;
                button3.setTextColor(com.baidu.ufosdk.b.y);
                return;
            case 1:
                aVar = this.f5556a.U;
                if (aVar.c().size() > 0) {
                    button2 = this.f5556a.m;
                    button2.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                    return;
                }
                button = this.f5556a.m;
                button.setTextColor(com.baidu.ufosdk.b.y);
                return;
            default:
                return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        editText = this.f5556a.t;
        if (editText.getText().toString().trim().length() < 4) {
            this.f5557b = 0;
        } else {
            this.f5557b = 1;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
