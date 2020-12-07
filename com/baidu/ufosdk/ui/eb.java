package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes22.dex */
final class eb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(FeedbackReportActivity feedbackReportActivity) {
        this.f3852a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        z = this.f3852a.B;
        if (z) {
            return;
        }
        editText = this.f3852a.u;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f3852a.b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f3852a.b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f3852a.b;
        editor2.commit();
        FeedbackReportActivity.o(this.f3852a);
    }
}
