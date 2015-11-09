package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        intent.getAction().equals(com.baidu.tbadk.data.b.zW());
    }
}
