package com.baidu.tieba.play;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes5.dex */
public class CallStateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getCallState() == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CallStateMessage(1));
        }
    }

    public void register(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            context.registerReceiver(this, intentFilter);
        }
    }

    public void unregister(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
