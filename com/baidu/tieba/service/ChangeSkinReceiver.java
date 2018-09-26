package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ChangeSkinReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        TbadkApplication.getInst().setSkinTypeValue(intent.getIntExtra(TbConfig.BROADCAST_FIELD_SKIN_TYPE, 0));
    }
}
