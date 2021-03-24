package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes5.dex */
public class SDCardChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            MessageManager.getInstance().runTask(2004603, (Class) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
