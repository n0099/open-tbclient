package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.baidu.tieba.util.z;
import com.mofamulu.tieba.ch.am;
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            am.a(context);
            WebView.disablePlatformNotifications();
            WebView.enablePlatformNotifications();
        } catch (Exception e) {
            z.b(getClass().getName(), "onReceive", e.getMessage());
        }
    }
}
