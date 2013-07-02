package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ChangeSkinReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TiebaApplication.f().k(intent.getIntExtra("skin_type", 0));
    }
}
