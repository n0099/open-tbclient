package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes22.dex */
final class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3895a;
    private long b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FeedbackEditActivity feedbackEditActivity) {
        this.f3895a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        EditText editText;
        SharedPreferences.Editor editor;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        if (System.currentTimeMillis() - this.b < IMConnection.RETRY_DELAY_TIMES) {
            return;
        }
        z = this.f3895a.v;
        if (z) {
            return;
        }
        this.b = System.currentTimeMillis();
        editText = this.f3895a.n;
        String obj = editText.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            editor = this.f3895a.b;
            editor.putString("cryptContactData", "");
        } else {
            editor3 = this.f3895a.b;
            editor3.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        editor2 = this.f3895a.b;
        editor2.commit();
        FeedbackEditActivity.h(this.f3895a);
    }
}
