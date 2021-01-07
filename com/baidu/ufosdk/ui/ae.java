package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.IMConnection;
import com.tencent.connect.common.Constants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ae implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5710a;

    /* renamed from: b  reason: collision with root package name */
    private int f5711b;
    private long c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FeedbackEditActivity feedbackEditActivity) {
        this.f5710a = feedbackEditActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        EditText editText;
        EditText editText2;
        TextView textView;
        EditText editText3;
        EditText editText4;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        EditText editText5;
        List list;
        List list2;
        Button button;
        List list3;
        List list4;
        Button button2;
        List list5;
        Button button3;
        EditText editText6;
        List list6;
        List list7;
        Button button4;
        List list8;
        List list9;
        Button button5;
        List list10;
        Button button6;
        Button button7;
        Button button8;
        TextView textView5;
        TextView textView6;
        int i = 0;
        z = this.f5710a.x;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f5710a);
            dVar.b(dVar.b() + 1);
            this.f5710a.x = true;
        }
        editText = this.f5710a.m;
        int length = editText.getText().toString().length();
        if (length < com.baidu.ufosdk.b.aa - 10) {
            textView5 = this.f5710a.o;
            textView5.setTextColor(-5131855);
            textView6 = this.f5710a.o;
            textView6.setText("4-" + com.baidu.ufosdk.b.aa + com.baidu.ufosdk.f.s.a("27"));
        } else if (length < com.baidu.ufosdk.b.aa - 10 || length > com.baidu.ufosdk.b.aa) {
            editText2 = this.f5710a.m;
            String substring = editText2.getText().toString().substring(0, com.baidu.ufosdk.b.aa);
            textView = this.f5710a.o;
            textView.setTextColor(-1551537);
            editText3 = this.f5710a.m;
            editText3.setText(substring);
            editText4 = this.f5710a.m;
            FeedbackEditActivity.b(editText4, substring.length());
            textView2 = this.f5710a.o;
            textView2.setText("0" + com.baidu.ufosdk.f.s.a("27"));
            if (System.currentTimeMillis() - this.c > IMConnection.RETRY_DELAY_TIMES) {
                Toast.makeText(this.f5710a, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
                this.c = System.currentTimeMillis();
            }
        } else {
            textView3 = this.f5710a.o;
            textView3.setTextColor(-5131855);
            textView4 = this.f5710a.o;
            textView4.setText(String.valueOf(com.baidu.ufosdk.b.aa - editable.length()) + com.baidu.ufosdk.f.s.a("27"));
        }
        switch (this.f5711b) {
            case 0:
                editText6 = this.f5710a.m;
                if (editText6.getText().toString().length() < 4) {
                    button7 = this.f5710a.V;
                    button7.setTextColor(com.baidu.ufosdk.b.y);
                    return;
                }
                while (true) {
                    int i2 = i;
                    list6 = this.f5710a.z;
                    if (i2 < list6.size()) {
                        list8 = this.f5710a.z;
                        if (list8.get(i2) != null) {
                            list10 = this.f5710a.z;
                            if (((TextView) list10.get(i2)).getText().toString().length() == 0) {
                                button6 = this.f5710a.V;
                                button6.setTextColor(com.baidu.ufosdk.b.y);
                            }
                        }
                        list9 = this.f5710a.z;
                        if (i2 == list9.size() - 1) {
                            button5 = this.f5710a.V;
                            button5.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                        }
                        i = i2 + 1;
                    }
                }
                list7 = this.f5710a.z;
                if (list7.size() == 0) {
                    button4 = this.f5710a.V;
                    button4.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                    return;
                }
                return;
            case 1:
                editText5 = this.f5710a.m;
                if (editText5.getText().toString().length() >= 4) {
                    while (true) {
                        int i3 = i;
                        list = this.f5710a.z;
                        if (i3 < list.size()) {
                            list3 = this.f5710a.z;
                            if (list3.get(i3) != null) {
                                list5 = this.f5710a.z;
                                if (((TextView) list5.get(i3)).getText().toString().length() == 0) {
                                    button3 = this.f5710a.V;
                                    button3.setTextColor(com.baidu.ufosdk.b.y);
                                }
                            }
                            list4 = this.f5710a.z;
                            if (i3 == list4.size() - 1) {
                                button2 = this.f5710a.V;
                                button2.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                            }
                            i = i3 + 1;
                        }
                    }
                    list2 = this.f5710a.z;
                    if (list2.size() == 0) {
                        button = this.f5710a.V;
                        button.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                        return;
                    }
                    return;
                }
                break;
        }
        button8 = this.f5710a.V;
        button8.setTextColor(com.baidu.ufosdk.b.y);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        editText = this.f5710a.m;
        if (editText.getText().toString().length() < 4) {
            this.f5711b = 0;
        } else {
            this.f5711b = 1;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
