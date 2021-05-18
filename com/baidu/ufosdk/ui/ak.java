package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.webkit.sdk.WebKitFactory;
/* loaded from: classes5.dex */
public final class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f22707a;

    public ak(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f22707a = feedbackFacePageActivity;
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
            Toast.makeText(this.f22707a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(this.f22707a.getApplicationContext())) {
                new Thread(new al(this)).start();
                return;
            } else {
                Toast.makeText(this.f22707a.getApplicationContext(), com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 1).show();
                return;
            }
        }
        try {
            if (com.baidu.ufosdk.f.h.a()) {
                return;
            }
            String b2 = com.baidu.ufosdk.f.i.b(System.currentTimeMillis());
            String str2 = UfoSDK.startStr;
            if (str2.equals(b2 + "-enable")) {
                sharedPreferences = this.f22707a.f22641b;
                if (!sharedPreferences.getBoolean("robotUv_has", false)) {
                    sharedPreferences2 = this.f22707a.f22641b;
                    int i2 = sharedPreferences2.getInt("robotUv", 0);
                    editor2 = this.f22707a.f22640a;
                    editor2.putInt("robotUv", i2 + 1);
                    editor3 = this.f22707a.f22640a;
                    editor3.putBoolean("robotUv_has", true);
                }
                editor = this.f22707a.f22640a;
                editor.commit();
            }
            Intent intent = new Intent();
            intent.setClass(this.f22707a, FeedbackInputActivity.class);
            str = this.f22707a.t;
            intent.putExtra("msgid", str);
            intent.putExtra("fromlist", "no");
            intent.putExtra("from_facepage", true);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.f22707a.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
