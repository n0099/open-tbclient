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
    public final /* synthetic */ FeedbackInputActivity f22770a;

    public bi(FeedbackInputActivity feedbackInputActivity) {
        this.f22770a = feedbackInputActivity;
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
            handler2 = this.f22770a.aK;
            handler2.obtainMessage(2, parcelableArrayList).sendToTarget();
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getmsgid")) {
            this.f22770a.f22704e = intent.getStringExtra("msgid");
            str = this.f22770a.ar;
            if (str != null) {
                str3 = this.f22770a.ar;
                if (str3.length() > 0) {
                    str2 = this.f22770a.ar;
                    feedbackInputActivity = this.f22770a;
                    if (feedbackInputActivity.f22706g == null) {
                        feedbackInputActivity.f22706g = new com.baidu.ufosdk.a.a(this.f22770a.getApplicationContext(), this.f22770a.f22704e, str2);
                    }
                    this.f22770a.f22706g.b();
                    if (!this.f22770a.f22706g.isAlive()) {
                        this.f22770a.f22706g.start();
                    }
                }
            }
            str2 = UfoSDK.appid;
            feedbackInputActivity = this.f22770a;
            if (feedbackInputActivity.f22706g == null) {
            }
            this.f22770a.f22706g.b();
            if (!this.f22770a.f22706g.isAlive()) {
            }
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            this.f22770a.k.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            handler = this.f22770a.aK;
            handler.obtainMessage(4, null).sendToTarget();
        }
    }
}
