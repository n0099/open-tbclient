package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes5.dex */
public final class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22991a;

    /* renamed from: b  reason: collision with root package name */
    public long f22992b = 0;

    public z(FeedbackEditActivity feedbackEditActivity) {
        this.f22991a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        if (System.currentTimeMillis() - this.f22992b < 3000) {
            return;
        }
        z = this.f22991a.v;
        if (z) {
            return;
        }
        this.f22992b = System.currentTimeMillis();
        editText = this.f22991a.n;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f22991a.f22675b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f22991a.f22675b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f22991a.f22675b;
        editor2.commit();
        FeedbackEditActivity.h(this.f22991a);
    }
}
