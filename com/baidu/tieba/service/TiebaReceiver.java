package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TiebaApplication.a().a(intent.getLongExtra("relay", 0L), intent.getLongExtra("at_me", 0L), intent.getLongExtra("fans", 0L));
    }
}
