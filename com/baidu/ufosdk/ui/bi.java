package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
import java.util.ArrayList;
/* loaded from: classes21.dex */
final class bi extends BroadcastReceiver {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        Handler handler;
        String str;
        String str2;
        String str3;
        Handler handler2;
        if (intent.getAction().equals("com.baidu.ufosdk.getchat")) {
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("msgList");
            handler2 = this.a.aK;
            handler2.obtainMessage(2, parcelableArrayList).sendToTarget();
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
            this.a.e = intent.getStringExtra("msgid");
            str = this.a.ar;
            if (str != null) {
                str3 = this.a.ar;
                if (str3.length() > 0) {
                    str2 = this.a.ar;
                    if (this.a.g == null) {
                        this.a.g = new com.baidu.ufosdk.a.a(this.a.getApplicationContext(), this.a.e, str2);
                    }
                    this.a.g.b();
                    if (!this.a.g.isAlive()) {
                        this.a.g.start();
                    }
                }
            }
            str2 = UfoSDK.appid;
            if (this.a.g == null) {
            }
            this.a.g.b();
            if (!this.a.g.isAlive()) {
            }
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            this.a.k.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            handler = this.a.aK;
            handler.obtainMessage(4, null).sendToTarget();
        }
    }
}
