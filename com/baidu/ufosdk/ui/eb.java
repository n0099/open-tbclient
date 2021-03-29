package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes5.dex */
public final class eb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23205a;

    public eb(FeedbackReportActivity feedbackReportActivity) {
        this.f23205a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        z = this.f23205a.B;
        if (z) {
            return;
        }
        editText = this.f23205a.u;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f23205a.f23032b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f23205a.f23032b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f23205a.f23032b;
        editor2.commit();
        FeedbackReportActivity.o(this.f23205a);
    }
}
