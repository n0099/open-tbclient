package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.ufosdk.UfoSDK;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f5434a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f5434a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(this.f5434a.getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            if (com.baidu.ufosdk.b.d.b(this.f5434a.getApplicationContext()).contains(RomUtils.UNKNOWN) || com.baidu.ufosdk.b.d.b(this.f5434a.getApplicationContext()).contains("NONE")) {
                return;
            }
            new Thread(new aj(this)).start();
            return;
        }
        try {
            if (com.baidu.ufosdk.f.h.a()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.f5434a, FeedbackEditActivity.class);
            str = this.f5434a.t;
            intent.putExtra("msgid", str);
            intent.putExtra("fromlist", "no");
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("come_from", 2);
            this.f5434a.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
