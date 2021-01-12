package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
import java.util.ArrayList;
/* loaded from: classes7.dex */
final class bi extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(FeedbackInputActivity feedbackInputActivity) {
        this.f5460a = feedbackInputActivity;
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
            handler2 = this.f5460a.aK;
            handler2.obtainMessage(2, parcelableArrayList).sendToTarget();
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
            this.f5460a.e = intent.getStringExtra("msgid");
            str = this.f5460a.ar;
            if (str != null) {
                str3 = this.f5460a.ar;
                if (str3.length() > 0) {
                    str2 = this.f5460a.ar;
                    if (this.f5460a.g == null) {
                        this.f5460a.g = new com.baidu.ufosdk.a.a(this.f5460a.getApplicationContext(), this.f5460a.e, str2);
                    }
                    this.f5460a.g.b();
                    if (!this.f5460a.g.isAlive()) {
                        this.f5460a.g.start();
                    }
                }
            }
            str2 = UfoSDK.appid;
            if (this.f5460a.g == null) {
            }
            this.f5460a.g.b();
            if (!this.f5460a.g.isAlive()) {
            }
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            this.f5460a.k.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            handler = this.f5460a.aK;
            handler.obtainMessage(4, null).sendToTarget();
        }
    }
}
