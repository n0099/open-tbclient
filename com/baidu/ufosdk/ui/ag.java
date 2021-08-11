package com.baidu.ufosdk.ui;

import android.content.Intent;
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
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ag extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f59337a;

    public ag(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59337a = new WeakReference(feedbackEditActivity);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        EditText editText;
        EditText editText2;
        View view;
        String str;
        String str2;
        SharedPreferences.Editor editor;
        View view2;
        int i2;
        SharedPreferences.Editor editor2;
        String str3;
        String str4;
        SharedPreferences.Editor editor3;
        String str5;
        View view3;
        Button button;
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
            FeedbackEditActivity feedbackEditActivity = (FeedbackEditActivity) this.f59337a.get();
            feedbackEditActivity.a(true);
            com.baidu.ufosdk.f.c.a("msg.what = " + message.what);
            if (feedbackEditActivity == null) {
                return;
            }
            if (message.what == 0) {
                com.baidu.ufosdk.f.c.a("--- msg.what = 0 ---");
            }
            int i3 = message.what;
            if (i3 == 12) {
                feedbackEditActivity.v = false;
                FeedbackEditActivity.x(feedbackEditActivity);
                feedbackEditActivity.s = Boolean.FALSE;
                str6 = feedbackEditActivity.t;
                if (!TextUtils.isEmpty(str6)) {
                    str9 = feedbackEditActivity.f59265g;
                    if (TextUtils.isEmpty(str9)) {
                        editor6 = feedbackEditActivity.f59260b;
                        str10 = feedbackEditActivity.t;
                        editor6.putString(str10, "");
                    }
                }
                str7 = feedbackEditActivity.f59265g;
                if (!TextUtils.isEmpty(str7)) {
                    editor5 = feedbackEditActivity.f59260b;
                    str8 = feedbackEditActivity.f59265g;
                    editor5.putString(str8, "");
                }
                editor4 = feedbackEditActivity.f59260b;
                editor4.commit();
                view4 = feedbackEditActivity.u;
                view4.setVisibility(8);
                feedbackEditActivity.finish();
            } else if (i3 == 13) {
                feedbackEditActivity.v = false;
                view3 = feedbackEditActivity.u;
                view3.setVisibility(8);
                button = feedbackEditActivity.V;
                button.setTextColor(com.baidu.ufosdk.b.v);
                Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("63"), 1).show();
            } else if (i3 != 14) {
                if (i3 == 15) {
                    try {
                        editText = feedbackEditActivity.m;
                        editText2 = feedbackEditActivity.m;
                        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
                    } catch (Exception unused) {
                    }
                } else if (i3 == 16) {
                    if (feedbackEditActivity.getCurrentFocus() == null || feedbackEditActivity.getCurrentFocus().getWindowToken() == null) {
                        return;
                    }
                    ((InputMethodManager) feedbackEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity.getCurrentFocus().getWindowToken(), 2);
                } else if (i3 == 17) {
                    feedbackEditActivity.b();
                } else if (i3 == 18) {
                    try {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        feedbackEditActivity.Z = jSONObject.getString("title_context");
                        feedbackEditActivity.aa = jSONObject.getString("hint_context");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (i3 == 19) {
                    Object obj = message.obj;
                    Toast.makeText(feedbackEditActivity, (obj == null || obj.toString().length() <= 0) ? com.baidu.ufosdk.f.s.a("63") : message.obj.toString(), 0).show();
                    feedbackEditActivity.v = false;
                    view = feedbackEditActivity.u;
                    view.setVisibility(8);
                }
            } else {
                feedbackEditActivity.v = false;
                FeedbackEditActivity.x(feedbackEditActivity);
                feedbackEditActivity.s = Boolean.FALSE;
                str = feedbackEditActivity.t;
                if (!TextUtils.isEmpty(str)) {
                    str4 = feedbackEditActivity.f59265g;
                    if (TextUtils.isEmpty(str4)) {
                        editor3 = feedbackEditActivity.f59260b;
                        str5 = feedbackEditActivity.t;
                        editor3.putString(str5, "");
                    }
                }
                str2 = feedbackEditActivity.f59265g;
                if (!TextUtils.isEmpty(str2)) {
                    editor2 = feedbackEditActivity.f59260b;
                    str3 = feedbackEditActivity.f59265g;
                    editor2.putString(str3, "");
                }
                editor = feedbackEditActivity.f59260b;
                editor.commit();
                view2 = feedbackEditActivity.u;
                view2.setVisibility(8);
                i2 = feedbackEditActivity.X;
                if (i2 == 1) {
                    Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("44"), 0).show();
                    feedbackEditActivity.finish();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(feedbackEditActivity, FeedbackInputActivity.class);
                intent.putExtra("msgid", (String) message.obj);
                intent.putExtra("openList", true);
                intent.putExtra("fromEdit", true);
                feedbackEditActivity.startActivity(intent);
                feedbackEditActivity.finish();
            }
        }
    }
}
