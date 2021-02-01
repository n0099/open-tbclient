package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f5436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f5436a = feedbackFacePageActivity;
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
            Toast.makeText(this.f5436a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(this.f5436a.getApplicationContext())) {
                new Thread(new al(this)).start();
                return;
            } else {
                Toast.makeText(this.f5436a.getApplicationContext(), com.baidu.ufosdk.f.s.a("64"), 1).show();
                return;
            }
        }
        try {
            if (com.baidu.ufosdk.f.h.a()) {
                return;
            }
            if (UfoSDK.startStr.equals(com.baidu.ufosdk.f.i.b(System.currentTimeMillis()) + "-enable")) {
                sharedPreferences = this.f5436a.f5411b;
                if (!sharedPreferences.getBoolean("robotUv_has", false)) {
                    sharedPreferences2 = this.f5436a.f5411b;
                    int i = sharedPreferences2.getInt("robotUv", 0);
                    editor2 = this.f5436a.f5410a;
                    editor2.putInt("robotUv", i + 1);
                    editor3 = this.f5436a.f5410a;
                    editor3.putBoolean("robotUv_has", true);
                }
                editor = this.f5436a.f5410a;
                editor.commit();
            }
            Intent intent = new Intent();
            intent.setClass(this.f5436a, FeedbackInputActivity.class);
            str = this.f5436a.t;
            intent.putExtra("msgid", str);
            intent.putExtra("fromlist", "no");
            intent.putExtra("from_facepage", true);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.f5436a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
