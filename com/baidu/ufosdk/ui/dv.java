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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ReportCallback;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public final class dv extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackReportActivity a;

    public dv(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            if (message.what == 0) {
                com.baidu.ufosdk.f.c.a("--- msg.what = 0 ---");
            }
            int i2 = message.what;
            if (i2 == 12) {
                this.a.B = false;
                FeedbackReportActivity.b(this.a);
                z2 = this.a.C;
                if (z2) {
                    this.a.C = false;
                    return;
                }
                this.a.y = Boolean.FALSE;
                str6 = this.a.z;
                if (!TextUtils.isEmpty(str6)) {
                    str9 = this.a.f51629g;
                    if (TextUtils.isEmpty(str9)) {
                        editor6 = this.a.f51624b;
                        str10 = this.a.z;
                        editor6.putString(str10, "");
                    }
                }
                str7 = this.a.f51629g;
                if (!TextUtils.isEmpty(str7)) {
                    editor5 = this.a.f51624b;
                    str8 = this.a.f51629g;
                    editor5.putString(str8, "");
                }
                editor4 = this.a.f51624b;
                editor4.commit();
                view4 = this.a.A;
                view4.setVisibility(8);
                Toast.makeText(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("59"), 0).show();
                this.a.finish();
            } else if (i2 == 13) {
                this.a.B = false;
                view3 = this.a.A;
                view3.setVisibility(8);
                button = this.a.m;
                button.setTextColor(com.baidu.ufosdk.b.v);
                this.a.finish();
            } else if (i2 != 14) {
                if (i2 == 15) {
                    try {
                        editText = this.a.t;
                        editText2 = this.a.t;
                        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                    } catch (Exception unused) {
                    }
                } else if (i2 == 16) {
                    if (this.a.getCurrentFocus() == null || this.a.getCurrentFocus().getWindowToken() == null) {
                        return;
                    }
                    ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
                } else if (i2 == 17) {
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
                this.a.y = Boolean.FALSE;
                str = this.a.z;
                if (!TextUtils.isEmpty(str)) {
                    str4 = this.a.f51629g;
                    if (TextUtils.isEmpty(str4)) {
                        editor3 = this.a.f51624b;
                        str5 = this.a.z;
                        editor3.putString(str5, "");
                    }
                }
                str2 = this.a.f51629g;
                if (!TextUtils.isEmpty(str2)) {
                    editor2 = this.a.f51624b;
                    str3 = this.a.f51629g;
                    editor2.putString(str3, "");
                }
                editor = this.a.f51624b;
                editor.commit();
                view2 = this.a.A;
                view2.setVisibility(8);
                ReportCallback reportCallback = com.baidu.ufosdk.b.af;
                if (reportCallback != null) {
                    reportCallback.getReportResult(1);
                    ReportCallback reportCallback2 = com.baidu.ufosdk.b.af;
                    jSONArray = this.a.I;
                    String jSONArray3 = jSONArray.toString();
                    jSONArray2 = this.a.J;
                    reportCallback2.getReportContent(jSONArray3, jSONArray2.toString());
                }
                Toast.makeText(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("59"), 0).show();
                this.a.finish();
            }
        }
    }
}
