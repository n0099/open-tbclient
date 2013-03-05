package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.baidu.tieba.c.ag;
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            WebView.disablePlatformNotifications();
            WebView.enablePlatformNotifications();
        } catch (Exception e) {
            ag.b(getClass().getName(), "onReceive", e.getMessage());
        }
    }
}
