package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class aa implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f22730a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22731b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22732c;

    public aa(FeedbackEditActivity feedbackEditActivity, EditText editText, String str) {
        this.f22732c = feedbackEditActivity;
        this.f22730a = editText;
        this.f22731b = str;
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x004b */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        this.f22732c.ad = this.f22730a.getText().toString();
        str = this.f22732c.ad;
        Log.d("editcontent", str);
        FeedbackEditActivity feedbackEditActivity = this.f22732c;
        Map map = feedbackEditActivity.f22674a;
        String str5 = this.f22731b;
        str2 = feedbackEditActivity.ad;
        map.put(str5, str2);
        str3 = this.f22732c.ad;
        if (str3 != null) {
            str4 = this.f22732c.ad;
            if (str4.trim().length() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    list2 = this.f22732c.z;
                    if (list2.get(i) != null) {
                        list4 = this.f22732c.z;
                        if (((TextView) list4.get(i)).getText().toString().trim().length() == 0) {
                        }
                    }
                    list3 = this.f22732c.z;
                    if (i == list3.size() - 1) {
                        editText = this.f22732c.m;
                        if (editText.getText().toString().trim().length() >= 4) {
                            button2 = this.f22732c.V;
                            int i2 = com.baidu.ufosdk.b.v;
                            int i3 = com.baidu.ufosdk.b.y;
                            int i4 = com.baidu.ufosdk.b.v;
                            button2.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
                        }
                    }
                }
                return;
            }
        }
        button = this.f22732c.V;
        button.setTextColor(com.baidu.ufosdk.b.y);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
