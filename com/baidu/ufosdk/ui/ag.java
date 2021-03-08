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
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes7.dex */
final class ag extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f3653a;

    public ag(FeedbackEditActivity feedbackEditActivity) {
        this.f3653a = new WeakReference(feedbackEditActivity);
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
        int i;
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
        super.handleMessage(message);
        FeedbackEditActivity feedbackEditActivity = (FeedbackEditActivity) this.f3653a.get();
        feedbackEditActivity.a(true);
        com.baidu.ufosdk.f.c.a("msg.what = " + message.what);
        if (feedbackEditActivity == null) {
            return;
        }
        if (message.what == 0) {
            com.baidu.ufosdk.f.c.a("--- msg.what = 0 ---");
        }
        if (message.what == 12) {
            feedbackEditActivity.v = false;
            FeedbackEditActivity.x(feedbackEditActivity);
            feedbackEditActivity.s = false;
            str6 = feedbackEditActivity.t;
            if (!TextUtils.isEmpty(str6)) {
                str9 = feedbackEditActivity.g;
                if (TextUtils.isEmpty(str9)) {
                    editor6 = feedbackEditActivity.b;
                    str10 = feedbackEditActivity.t;
                    editor6.putString(str10, "");
                }
            }
            str7 = feedbackEditActivity.g;
            if (!TextUtils.isEmpty(str7)) {
                editor5 = feedbackEditActivity.b;
                str8 = feedbackEditActivity.g;
                editor5.putString(str8, "");
            }
            editor4 = feedbackEditActivity.b;
            editor4.commit();
            view4 = feedbackEditActivity.u;
            view4.setVisibility(8);
            feedbackEditActivity.finish();
        } else if (message.what == 13) {
            feedbackEditActivity.v = false;
            view3 = feedbackEditActivity.u;
            view3.setVisibility(8);
            button = feedbackEditActivity.V;
            button.setTextColor(com.baidu.ufosdk.b.v);
            Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("63"), 1).show();
        } else if (message.what == 14) {
            feedbackEditActivity.v = false;
            FeedbackEditActivity.x(feedbackEditActivity);
            feedbackEditActivity.s = false;
            str = feedbackEditActivity.t;
            if (!TextUtils.isEmpty(str)) {
                str4 = feedbackEditActivity.g;
                if (TextUtils.isEmpty(str4)) {
                    editor3 = feedbackEditActivity.b;
                    str5 = feedbackEditActivity.t;
                    editor3.putString(str5, "");
                }
            }
            str2 = feedbackEditActivity.g;
            if (!TextUtils.isEmpty(str2)) {
                editor2 = feedbackEditActivity.b;
                str3 = feedbackEditActivity.g;
                editor2.putString(str3, "");
            }
            editor = feedbackEditActivity.b;
            editor.commit();
            view2 = feedbackEditActivity.u;
            view2.setVisibility(8);
            i = feedbackEditActivity.X;
            if (i == 1) {
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
        } else if (message.what == 15) {
            try {
                editText = feedbackEditActivity.m;
                editText2 = feedbackEditActivity.m;
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText2, 0);
            } catch (Exception e) {
            }
        } else if (message.what == 16) {
            if (feedbackEditActivity.getCurrentFocus() == null || feedbackEditActivity.getCurrentFocus().getWindowToken() == null) {
                return;
            }
            ((InputMethodManager) feedbackEditActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackEditActivity.getCurrentFocus().getWindowToken(), 2);
        } else if (message.what == 17) {
            feedbackEditActivity.b();
        } else if (message.what == 18) {
            try {
                JSONObject jSONObject = (JSONObject) message.obj;
                feedbackEditActivity.Z = jSONObject.getString("title_context");
                feedbackEditActivity.aa = jSONObject.getString("hint_context");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (message.what == 19) {
            if (message.obj == null || message.obj.toString().length() <= 0) {
                Toast.makeText(feedbackEditActivity, com.baidu.ufosdk.f.s.a("63"), 0).show();
            } else {
                Toast.makeText(feedbackEditActivity, message.obj.toString(), 0).show();
            }
            feedbackEditActivity.v = false;
            view = feedbackEditActivity.u;
            view.setVisibility(8);
        }
    }
}
