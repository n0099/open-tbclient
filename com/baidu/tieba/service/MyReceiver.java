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
    private int curNetType = 0;

    public MyReceiver(RecommendActivity acti) {
        this.activity = null;
        this.activity = acti;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent arg1) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeInfo = manager.getActiveNetworkInfo();
        if (activeInfo != null) {
            int type = activeInfo.getType();
            if (this.curNetType == 0 && type != 0) {
                this.activity.resetProxy(1001);
                this.curNetType = type;
            } else if (this.curNetType == 1 && type != 1) {
                this.activity.resetProxy(1002);
                this.curNetType = type;
            } else {
                this.activity.resetProxy(1003);
                this.curNetType = type;
            }
        }
    }
}
