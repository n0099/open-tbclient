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
/* loaded from: classes5.dex */
public final class dv extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22844a;

    public dv(FeedbackReportActivity feedbackReportActivity) {
        this.f22844a = feedbackReportActivity;
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
        int i2 = message.what;
        if (i2 == 12) {
            this.f22844a.B = false;
            FeedbackReportActivity.b(this.f22844a);
            z2 = this.f22844a.C;
            if (z2) {
                this.f22844a.C = false;
                return;
            }
            this.f22844a.y = Boolean.FALSE;
            str6 = this.f22844a.z;
            if (!TextUtils.isEmpty(str6)) {
                str9 = this.f22844a.f22684g;
                if (TextUtils.isEmpty(str9)) {
                    editor6 = this.f22844a.f22679b;
                    str10 = this.f22844a.z;
                    editor6.putString(str10, "");
                }
            }
            str7 = this.f22844a.f22684g;
            if (!TextUtils.isEmpty(str7)) {
                editor5 = this.f22844a.f22679b;
                str8 = this.f22844a.f22684g;
                editor5.putString(str8, "");
            }
            editor4 = this.f22844a.f22679b;
            editor4.commit();
            view4 = this.f22844a.A;
            view4.setVisibility(8);
            Toast.makeText(this.f22844a.getApplicationContext(), com.baidu.ufosdk.f.s.a("59"), 0).show();
            this.f22844a.finish();
        } else if (i2 == 13) {
            this.f22844a.B = false;
            view3 = this.f22844a.A;
            view3.setVisibility(8);
            button = this.f22844a.m;
            button.setTextColor(com.baidu.ufosdk.b.v);
            this.f22844a.finish();
        } else if (i2 != 14) {
            if (i2 == 15) {
                try {
                    editText = this.f22844a.t;
                    editText2 = this.f22844a.t;
                    ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                } catch (Exception unused) {
                }
            } else if (i2 == 16) {
                if (this.f22844a.getCurrentFocus() == null || this.f22844a.getCurrentFocus().getWindowToken() == null) {
                    return;
                }
                ((InputMethodManager) this.f22844a.getSystemService("input_method")).hideSoftInputFromWindow(this.f22844a.getCurrentFocus().getWindowToken(), 2);
            } else if (i2 == 17) {
                this.f22844a.B = false;
                view = this.f22844a.A;
                view.setVisibility(8);
            }
        } else {
            this.f22844a.B = false;
            FeedbackReportActivity.b(this.f22844a);
            z = this.f22844a.C;
            if (z) {
                this.f22844a.C = false;
                return;
            }
            this.f22844a.y = Boolean.FALSE;
            str = this.f22844a.z;
            if (!TextUtils.isEmpty(str)) {
                str4 = this.f22844a.f22684g;
                if (TextUtils.isEmpty(str4)) {
                    editor3 = this.f22844a.f22679b;
                    str5 = this.f22844a.z;
                    editor3.putString(str5, "");
                }
            }
            str2 = this.f22844a.f22684g;
            if (!TextUtils.isEmpty(str2)) {
                editor2 = this.f22844a.f22679b;
                str3 = this.f22844a.f22684g;
                editor2.putString(str3, "");
            }
            editor = this.f22844a.f22679b;
            editor.commit();
            view2 = this.f22844a.A;
            view2.setVisibility(8);
            ReportCallback reportCallback = com.baidu.ufosdk.b.af;
            if (reportCallback != null) {
                reportCallback.getReportResult(1);
                ReportCallback reportCallback2 = com.baidu.ufosdk.b.af;
                jSONArray = this.f22844a.I;
                String jSONArray3 = jSONArray.toString();
                jSONArray2 = this.f22844a.J;
                reportCallback2.getReportContent(jSONArray3, jSONArray2.toString());
            }
            Toast.makeText(this.f22844a.getApplicationContext(), com.baidu.ufosdk.f.s.a("59"), 0).show();
            this.f22844a.finish();
        }
    }
}
