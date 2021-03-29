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
    public final /* synthetic */ FeedbackFacePageActivity f23059a;

    public ak(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f23059a = feedbackFacePageActivity;
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
            Toast.makeText(this.f23059a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.c(this.f23059a.getApplicationContext())) {
                new Thread(new al(this)).start();
                return;
            } else {
                Toast.makeText(this.f23059a.getApplicationContext(), com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 1).show();
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
                sharedPreferences = this.f23059a.f22998b;
                if (!sharedPreferences.getBoolean("robotUv_has", false)) {
                    sharedPreferences2 = this.f23059a.f22998b;
                    int i = sharedPreferences2.getInt("robotUv", 0);
                    editor2 = this.f23059a.f22997a;
                    editor2.putInt("robotUv", i + 1);
                    editor3 = this.f23059a.f22997a;
                    editor3.putBoolean("robotUv_has", true);
                }
                editor = this.f23059a.f22997a;
                editor.commit();
            }
            Intent intent = new Intent();
            intent.setClass(this.f23059a, FeedbackInputActivity.class);
            str = this.f23059a.t;
            intent.putExtra("msgid", str);
            intent.putExtra("fromlist", "no");
            intent.putExtra("from_facepage", true);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.f23059a.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
