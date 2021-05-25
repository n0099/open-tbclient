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
    public final /* synthetic */ EditText f22622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22623b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22624c;

    public aa(FeedbackEditActivity feedbackEditActivity, EditText editText, String str) {
        this.f22624c = feedbackEditActivity;
        this.f22622a = editText;
        this.f22623b = str;
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
        this.f22624c.ad = this.f22622a.getText().toString();
        str = this.f22624c.ad;
        Log.d("editcontent", str);
        FeedbackEditActivity feedbackEditActivity = this.f22624c;
        Map map = feedbackEditActivity.f22560a;
        String str5 = this.f22623b;
        str2 = feedbackEditActivity.ad;
        map.put(str5, str2);
        str3 = this.f22624c.ad;
        if (str3 != null) {
            str4 = this.f22624c.ad;
            if (str4.trim().length() != 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    list2 = this.f22624c.z;
                    if (list2.get(i2) != null) {
                        list4 = this.f22624c.z;
                        if (((TextView) list4.get(i2)).getText().toString().trim().length() == 0) {
                        }
                    }
                    list3 = this.f22624c.z;
                    if (i2 == list3.size() - 1) {
                        editText = this.f22624c.m;
                        if (editText.getText().toString().trim().length() >= 4) {
                            button2 = this.f22624c.V;
                            int i3 = com.baidu.ufosdk.b.v;
                            int i4 = com.baidu.ufosdk.b.y;
                            int i5 = com.baidu.ufosdk.b.v;
                            button2.setTextColor(com.baidu.ufosdk.f.i.a(i3, i4, i5, i5));
                        }
                    }
                }
                return;
            }
        }
        button = this.f22624c.V;
        button.setTextColor(com.baidu.ufosdk.b.y);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
