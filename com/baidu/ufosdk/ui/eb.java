package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes21.dex */
final class eb implements View.OnClickListener {
    final /* synthetic */ FeedbackReportActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(FeedbackReportActivity feedbackReportActivity) {
        this.a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        z = this.a.B;
        if (z) {
            return;
        }
        editText = this.a.u;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.a.b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.a.b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.a.b;
        editor2.commit();
        FeedbackReportActivity.o(this.a);
    }
}
