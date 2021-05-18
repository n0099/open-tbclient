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
/* loaded from: classes5.dex */
public final class ag extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f22703a;

    public ag(FeedbackEditActivity feedbackEditActivity) {
        this.f22703a = new WeakReference(feedbackEditActivity);
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
        super.handleMessage(message);
        FeedbackEditActivity feedbackEditActivity = (FeedbackEditActivity) this.f22703a.get();
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
                str9 = feedbackEditActivity.f22637g;
                if (TextUtils.isEmpty(str9)) {
                    editor6 = feedbackEditActivity.f22632b;
                    str10 = feedbackEditActivity.t;
                    editor6.putString(str10, "");
                }
            }
            str7 = feedbackEditActivity.f22637g;
            if (!TextUtils.isEmpty(str7)) {
                editor5 = feedbackEditActivity.f22632b;
                str8 = feedbackEditActivity.f22637g;
                editor5.putString(str8, "");
            }
            editor4 = feedbackEditActivity.f22632b;
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
                str4 = feedbackEditActivity.f22637g;
                if (TextUtils.isEmpty(str4)) {
                    editor3 = feedbackEditActivity.f22632b;
                    str5 = feedbackEditActivity.t;
                    editor3.putString(str5, "");
                }
            }
            str2 = feedbackEditActivity.f22637g;
            if (!TextUtils.isEmpty(str2)) {
                editor2 = feedbackEditActivity.f22632b;
                str3 = feedbackEditActivity.f22637g;
                editor2.putString(str3, "");
            }
            editor = feedbackEditActivity.f22632b;
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
