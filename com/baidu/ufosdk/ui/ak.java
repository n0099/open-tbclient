package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class ak implements View.OnClickListener {
    final /* synthetic */ FeedbackFacePageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        SharedPreferences sharedPreferences2;
        SharedPreferences.Editor editor2;
        SharedPreferences.Editor editor3;
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(this.a.getApplicationContext())) {
                new Thread(new al(this)).start();
                return;
            } else {
                Toast.makeText(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("64"), 1).show();
                return;
            }
        }
        try {
            if (com.baidu.ufosdk.f.h.a()) {
                return;
            }
            if (UfoSDK.startStr.equals(com.baidu.ufosdk.f.i.b(System.currentTimeMillis()) + "-enable")) {
                sharedPreferences = this.a.b;
                if (!sharedPreferences.getBoolean("robotUv_has", false)) {
                    sharedPreferences2 = this.a.b;
                    int i = sharedPreferences2.getInt("robotUv", 0);
                    editor2 = this.a.a;
                    editor2.putInt("robotUv", i + 1);
                    editor3 = this.a.a;
                    editor3.putBoolean("robotUv_has", true);
                }
                editor = this.a.a;
                editor.commit();
            }
            Intent intent = new Intent();
            intent.setClass(this.a, FeedbackInputActivity.class);
            str = this.a.t;
            intent.putExtra("msgid", str);
            intent.putExtra("fromlist", "no");
            intent.putExtra("from_facepage", true);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
