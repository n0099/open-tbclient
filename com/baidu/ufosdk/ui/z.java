package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes5.dex */
public final class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f23712a;

    /* renamed from: b  reason: collision with root package name */
    public long f23713b = 0;

    public z(FeedbackEditActivity feedbackEditActivity) {
        this.f23712a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        if (System.currentTimeMillis() - this.f23713b < 3000) {
            return;
        }
        z = this.f23712a.v;
        if (z) {
            return;
        }
        this.f23713b = System.currentTimeMillis();
        editText = this.f23712a.n;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f23712a.f23387b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f23712a.f23387b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f23712a.f23387b;
        editor2.commit();
        FeedbackEditActivity.h(this.f23712a);
    }
}
