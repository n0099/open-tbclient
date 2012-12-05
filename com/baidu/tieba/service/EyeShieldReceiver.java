package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class EyeShieldReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean isEyeShieldMode = intent.getBooleanExtra("eyeshield_mode", false);
        TiebaApplication.app.setIsEyeShieldModeValue(isEyeShieldMode);
    }
}
