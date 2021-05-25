package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes5.dex */
public final class eb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22783a;

    public eb(FeedbackReportActivity feedbackReportActivity) {
        this.f22783a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        z = this.f22783a.B;
        if (z) {
            return;
        }
        editText = this.f22783a.u;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f22783a.f22608b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f22783a.f22608b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f22783a.f22608b;
        editor2.commit();
        FeedbackReportActivity.o(this.f22783a);
    }
}
