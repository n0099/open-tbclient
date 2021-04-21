package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.common.Constants;
import java.util.List;
/* loaded from: classes5.dex */
public final class ae implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22744a;

    /* renamed from: b  reason: collision with root package name */
    public int f22745b;

    /* renamed from: c  reason: collision with root package name */
    public long f22746c = 0;

    public ae(FeedbackEditActivity feedbackEditActivity) {
        this.f22744a = feedbackEditActivity;
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
        Button button;
        List list;
        List list2;
        Button button2;
        List list3;
        List list4;
        Button button3;
        List list5;
        Button button4;
        Button button5;
        EditText editText6;
        List list6;
        List list7;
        Button button6;
        List list8;
        List list9;
        Button button7;
        List list10;
        Button button8;
        TextView textView5;
        TextView textView6;
        z = this.f22744a.x;
        if (!z) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f22744a);
            dVar.b(dVar.b() + 1);
            this.f22744a.x = true;
        }
        editText = this.f22744a.m;
        int length = editText.getText().toString().length();
        int i = com.baidu.ufosdk.b.aa;
        int i2 = 0;
        if (length < i - 10) {
            textView5 = this.f22744a.o;
            textView5.setTextColor(-5131855);
            textView6 = this.f22744a.o;
            textView6.setText("4-" + com.baidu.ufosdk.b.aa + com.baidu.ufosdk.f.s.a("27"));
        } else if (length < i - 10 || length > i) {
            editText2 = this.f22744a.m;
            String substring = editText2.getText().toString().substring(0, com.baidu.ufosdk.b.aa);
            textView = this.f22744a.o;
            textView.setTextColor(-1551537);
            editText3 = this.f22744a.m;
            editText3.setText(substring);
            editText4 = this.f22744a.m;
            FeedbackEditActivity.b(editText4, substring.length());
            textView2 = this.f22744a.o;
            textView2.setText("0" + com.baidu.ufosdk.f.s.a("27"));
            if (System.currentTimeMillis() - this.f22746c > 3000) {
                Toast.makeText(this.f22744a, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
                this.f22746c = System.currentTimeMillis();
            }
        } else {
            textView3 = this.f22744a.o;
            textView3.setTextColor(-5131855);
            textView4 = this.f22744a.o;
            textView4.setText(String.valueOf(com.baidu.ufosdk.b.aa - editable.length()) + com.baidu.ufosdk.f.s.a("27"));
        }
        int i3 = this.f22745b;
        if (i3 == 0) {
            editText5 = this.f22744a.m;
            if (editText5.getText().toString().length() < 4) {
                button = this.f22744a.V;
                button.setTextColor(com.baidu.ufosdk.b.y);
                return;
            }
            while (true) {
                list = this.f22744a.z;
                if (i2 >= list.size()) {
                    break;
                }
                list3 = this.f22744a.z;
                if (list3.get(i2) != null) {
                    list5 = this.f22744a.z;
                    if (((TextView) list5.get(i2)).getText().toString().length() == 0) {
                        button4 = this.f22744a.V;
                        button4.setTextColor(com.baidu.ufosdk.b.y);
                        break;
                    }
                }
                list4 = this.f22744a.z;
                if (i2 == list4.size() - 1) {
                    button3 = this.f22744a.V;
                    int i4 = com.baidu.ufosdk.b.v;
                    int i5 = com.baidu.ufosdk.b.y;
                    int i6 = com.baidu.ufosdk.b.v;
                    button3.setTextColor(com.baidu.ufosdk.f.i.a(i4, i5, i6, i6));
                }
                i2++;
            }
            list2 = this.f22744a.z;
            if (list2.size() == 0) {
                button2 = this.f22744a.V;
                int i7 = com.baidu.ufosdk.b.v;
                int i8 = com.baidu.ufosdk.b.y;
                int i9 = com.baidu.ufosdk.b.v;
                button2.setTextColor(com.baidu.ufosdk.f.i.a(i7, i8, i9, i9));
                return;
            }
            return;
        }
        if (i3 == 1) {
            editText6 = this.f22744a.m;
            if (editText6.getText().toString().length() >= 4) {
                while (true) {
                    list6 = this.f22744a.z;
                    if (i2 >= list6.size()) {
                        break;
                    }
                    list8 = this.f22744a.z;
                    if (list8.get(i2) != null) {
                        list10 = this.f22744a.z;
                        if (((TextView) list10.get(i2)).getText().toString().length() == 0) {
                            button8 = this.f22744a.V;
                            button8.setTextColor(com.baidu.ufosdk.b.y);
                            break;
                        }
                    }
                    list9 = this.f22744a.z;
                    if (i2 == list9.size() - 1) {
                        button7 = this.f22744a.V;
                        int i10 = com.baidu.ufosdk.b.v;
                        int i11 = com.baidu.ufosdk.b.y;
                        int i12 = com.baidu.ufosdk.b.v;
                        button7.setTextColor(com.baidu.ufosdk.f.i.a(i10, i11, i12, i12));
                    }
                    i2++;
                }
                list7 = this.f22744a.z;
                if (list7.size() == 0) {
                    button6 = this.f22744a.V;
                    int i13 = com.baidu.ufosdk.b.v;
                    int i14 = com.baidu.ufosdk.b.y;
                    int i15 = com.baidu.ufosdk.b.v;
                    button6.setTextColor(com.baidu.ufosdk.f.i.a(i13, i14, i15, i15));
                    return;
                }
                return;
            }
        }
        button5 = this.f22744a.V;
        button5.setTextColor(com.baidu.ufosdk.b.y);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        editText = this.f22744a.m;
        this.f22745b = editText.getText().toString().length() < 4 ? 0 : 1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
