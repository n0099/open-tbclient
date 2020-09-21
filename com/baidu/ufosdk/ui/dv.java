package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.ufosdk.ReportCallback;
import org.json.JSONArray;
/* loaded from: classes21.dex */
final class dv extends Handler {
    final /* synthetic */ FeedbackReportActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(FeedbackReportActivity feedbackReportActivity) {
        this.a = feedbackReportActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        EditText editText;
        EditText editText2;
        View view;
        boolean z;
        String str;
        String str2;
        SharedPreferences.Editor editor;
        View view2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        SharedPreferences.Editor editor2;
        String str3;
        String str4;
        SharedPreferences.Editor editor3;
        String str5;
        View view3;
        Button button;
        boolean z2;
        String str6;
        String str7;
        SharedPreferences.Editor editor4;
        View view4;
        SharedPreferences.Editor editor5;
        String str8;
        String str9;
        SharedPreferences.Editor editor6;
        String str10;
        super.handleMessage(message);
        if (message.what == 0) {
            com.baidu.ufosdk.f.c.a("--- msg.what = 0 ---");
        }
        if (message.what == 12) {
            this.a.B = false;
            FeedbackReportActivity.b(this.a);
            z2 = this.a.C;
            if (z2) {
                this.a.C = false;
                return;
            }
            this.a.y = false;
            str6 = this.a.z;
            if (!TextUtils.isEmpty(str6)) {
                str9 = this.a.g;
                if (TextUtils.isEmpty(str9)) {
                    editor6 = this.a.b;
                    str10 = this.a.z;
                    editor6.putString(str10, "");
                }
            }
            str7 = this.a.g;
            if (!TextUtils.isEmpty(str7)) {
                editor5 = this.a.b;
                str8 = this.a.g;
                editor5.putString(str8, "");
            }
            editor4 = this.a.b;
            editor4.commit();
            view4 = this.a.A;
            view4.setVisibility(8);
            Toast.makeText(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("59"), 0).show();
            this.a.finish();
        } else if (message.what == 13) {
            this.a.B = false;
            view3 = this.a.A;
            view3.setVisibility(8);
            button = this.a.m;
            button.setTextColor(com.baidu.ufosdk.b.v);
            this.a.finish();
        } else if (message.what != 14) {
            if (message.what == 15) {
                try {
                    editText = this.a.t;
                    editText2 = this.a.t;
                    ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                } catch (Exception e) {
                }
            } else if (message.what == 16) {
                if (this.a.getCurrentFocus() == null || this.a.getCurrentFocus().getWindowToken() == null) {
                    return;
                }
                ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
            } else if (message.what == 17) {
                this.a.B = false;
                view = this.a.A;
                view.setVisibility(8);
            }
        } else {
            this.a.B = false;
            FeedbackReportActivity.b(this.a);
            z = this.a.C;
            if (z) {
                this.a.C = false;
                return;
            }
            this.a.y = false;
            str = this.a.z;
            if (!TextUtils.isEmpty(str)) {
                str4 = this.a.g;
                if (TextUtils.isEmpty(str4)) {
                    editor3 = this.a.b;
                    str5 = this.a.z;
                    editor3.putString(str5, "");
                }
            }
            str2 = this.a.g;
            if (!TextUtils.isEmpty(str2)) {
                editor2 = this.a.b;
                str3 = this.a.g;
                editor2.putString(str3, "");
            }
            editor = this.a.b;
            editor.commit();
            view2 = this.a.A;
            view2.setVisibility(8);
            if (com.baidu.ufosdk.b.af != null) {
                com.baidu.ufosdk.b.af.getReportResult(1);
                ReportCallback reportCallback = com.baidu.ufosdk.b.af;
                jSONArray = this.a.I;
                String jSONArray3 = jSONArray.toString();
                jSONArray2 = this.a.J;
                reportCallback.getReportContent(jSONArray3, jSONArray2.toString());
            }
            Toast.makeText(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("59"), 0).show();
            this.a.finish();
        }
    }
}
