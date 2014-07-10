package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        TbadkApplication.getCurrentAccount();
        if (!action.equals(com.baidu.tieba.data.e.b()) && action.equals(com.baidu.tieba.data.e.d())) {
            TbadkApplication.m252getInst().refreshNewVersion(true);
        }
    }
}
