package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!action.equals(com.baidu.tbadk.data.b.uD()) && action.equals(com.baidu.tbadk.data.b.uE())) {
            TbadkCoreApplication.m255getInst().refreshNewVersion(true);
        }
    }
}
