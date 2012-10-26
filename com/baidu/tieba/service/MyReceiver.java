package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.recommend.RecommendActivity;
/* loaded from: classes.dex */
public class MyReceiver extends BroadcastReceiver {
    private RecommendActivity activity;

    public MyReceiver(RecommendActivity acti) {
        this.activity = null;
        this.activity = acti;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent arg1) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeInfo = manager.getActiveNetworkInfo();
        if (activeInfo != null) {
            this.activity.resetProxy();
        }
    }
}
