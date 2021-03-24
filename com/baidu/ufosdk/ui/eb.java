package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes5.dex */
public final class eb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23204a;

    public eb(FeedbackReportActivity feedbackReportActivity) {
        this.f23204a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        z = this.f23204a.B;
        if (z) {
            return;
        }
        editText = this.f23204a.u;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f23204a.f23031b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f23204a.f23031b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f23204a.f23031b;
        editor2.commit();
        FeedbackReportActivity.o(this.f23204a);
    }
}
