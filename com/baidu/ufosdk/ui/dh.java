package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
/* loaded from: classes5.dex */
public final class dh extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22939a;

    public dh(FeedbackListActivity feedbackListActivity) {
        this.f22939a = feedbackListActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Handler handler;
        View view;
        View view2;
        ExecutorService executorService;
        ExecutorService executorService2;
        View view3;
        Handler handler2;
        if (intent.getAction().equals("com.baidu.ufosdk.gethistorylist")) {
            view3 = this.f22939a.w;
            view3.setVisibility(8);
            handler2 = this.f22939a.A;
            handler2.obtainMessage(0, (ArrayList) intent.getSerializableExtra("msgList")).sendToTarget();
            FeedbackListActivity.k(this.f22939a);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getnewhistoryflag")) {
            executorService2 = this.f22939a.y;
            executorService2.execute(new di(this));
        }
        if (intent.getAction().equals("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag")) {
            executorService = this.f22939a.y;
            executorService.execute(new dj(this));
        }
        if (intent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
            view = this.f22939a.v;
            view.setVisibility(8);
            view2 = this.f22939a.w;
            view2.setVisibility(8);
        }
        if (intent.getAction().equals("com.baidu.ufosdk.reload")) {
            handler = this.f22939a.A;
            handler.obtainMessage(1, null).sendToTarget();
        }
    }
}
