package com.baidu.tieba.play;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class CallStateReceiver extends BroadcastReceiver {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return;
        }
        switch (telephonyManager.getCallState()) {
            case 0:
            case 2:
            default:
                return;
            case 1:
                MessageManager.getInstance().dispatchResponsedMessage(new CallStateMessage(1));
                return;
        }
    }
}
