package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.aj;
import com.baidu.tieba.game.GameInstallReceiver;
/* loaded from: classes.dex */
public class InstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString;
        if (intent != null && intent.getAction() != null) {
            if (intent.getAction().equals(GameInstallReceiver.ACTION_INSTALL)) {
                String dataString2 = intent.getDataString();
                if (dataString2 != null && dataString2.equals("package:com.baidu.tieba")) {
                    aj.wm().bd(true);
                }
            } else if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED") && (dataString = intent.getDataString()) != null && dataString.equals("package:com.baidu.tieba")) {
                aj.wm().bd(false);
            }
        }
    }
}
