package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class aa implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditText f5424a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f5425b;
    final /* synthetic */ FeedbackEditActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FeedbackEditActivity feedbackEditActivity, EditText editText, String str) {
        this.c = feedbackEditActivity;
        this.f5424a = editText;
        this.f5425b = str;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        String str;
        String str2;
        String str3;
        Button button;
        String str4;
        List list;
        List list2;
        List list3;
        EditText editText;
        Button button2;
        List list4;
        Button button3;
        this.c.ad = this.f5424a.getText().toString();
        str = this.c.ad;
        Log.d("editcontent", str);
        Map map = this.c.f5408a;
        String str5 = this.f5425b;
        str2 = this.c.ad;
        map.put(str5, str2);
        str3 = this.c.ad;
        if (str3 != null) {
            str4 = this.c.ad;
            if (str4.trim().length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    list = this.c.z;
                    if (i2 >= list.size()) {
                        return;
                    }
                    list2 = this.c.z;
                    if (list2.get(i2) != null) {
                        list4 = this.c.z;
                        if (((TextView) list4.get(i2)).getText().toString().trim().length() == 0) {
                            button3 = this.c.V;
                            button3.setTextColor(com.baidu.ufosdk.b.y);
                            return;
                        }
                    }
                    list3 = this.c.z;
                    if (i2 == list3.size() - 1) {
                        editText = this.c.m;
                        if (editText.getText().toString().trim().length() >= 4) {
                            button2 = this.c.V;
                            button2.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        button = this.c.V;
        button.setTextColor(com.baidu.ufosdk.b.y);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
