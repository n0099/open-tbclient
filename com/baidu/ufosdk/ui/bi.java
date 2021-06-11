package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class bi extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22765a;

    public bi(FeedbackInputActivity feedbackInputActivity) {
        this.f22765a = feedbackInputActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        Handler handler;
        String str;
        String str2;
        FeedbackInputActivity feedbackInputActivity;
        String str3;
        Handler handler2;
        if (intent.getAction().equals("com.baidu.ufosdk.getchat")) {
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("msgList");
            handler2 = this.f22765a.aK;
            handler2.obtainMessage(2, parcelableArrayList).sendToTarget();
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
            this.f22765a.f22696e = intent.getStringExtra("msgid");
            str = this.f22765a.ar;
            if (str != null) {
                str3 = this.f22765a.ar;
                if (str3.length() > 0) {
                    str2 = this.f22765a.ar;
                    feedbackInputActivity = this.f22765a;
                    if (feedbackInputActivity.f22698g == null) {
                        feedbackInputActivity.f22698g = new com.baidu.ufosdk.a.a(this.f22765a.getApplicationContext(), this.f22765a.f22696e, str2);
                    }
                    this.f22765a.f22698g.b();
                    if (!this.f22765a.f22698g.isAlive()) {
                        this.f22765a.f22698g.start();
                    }
                }
            }
            str2 = UfoSDK.appid;
            feedbackInputActivity = this.f22765a;
            if (feedbackInputActivity.f22698g == null) {
            }
            this.f22765a.f22698g.b();
            if (!this.f22765a.f22698g.isAlive()) {
            }
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            this.f22765a.k.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            handler = this.f22765a.aK;
            handler.obtainMessage(4, null).sendToTarget();
        }
    }
}
