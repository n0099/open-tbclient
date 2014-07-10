package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.ai;
/* loaded from: classes.dex */
public class InstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString;
        if (intent != null && intent.getAction() != null) {
            if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                String dataString2 = intent.getDataString();
                if (dataString2 != null && dataString2.equals("package:com.baidu.tieba")) {
                    ai.c().p(true);
                }
            } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED") && (dataString = intent.getDataString()) != null && dataString.equals("package:com.baidu.tieba")) {
                ai.c().p(false);
            }
        }
    }
}
