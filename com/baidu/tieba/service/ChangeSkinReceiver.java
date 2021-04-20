package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes4.dex */
public class ChangeSkinReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("skin_type", 0);
        TbadkApplication.getInst().setSkinTypeValue(intExtra);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001304, Integer.valueOf(intExtra)));
    }
}
