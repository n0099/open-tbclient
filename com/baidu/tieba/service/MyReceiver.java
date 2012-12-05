package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.baidu.tieba.util.TiebaLog;
/* loaded from: classes.dex */
public class MyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent arg1) {
        try {
            WebView.disablePlatformNotifications();
            WebView.enablePlatformNotifications();
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "onReceive", e.getMessage());
        }
    }
}
