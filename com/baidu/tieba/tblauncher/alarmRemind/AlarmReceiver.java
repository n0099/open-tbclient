package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
/* loaded from: classes4.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (j.kY() && a.cgQ() && !a.aM(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("tieba_last_active_time", 0L))) {
            RemindRecommendMessage Da = a.Da(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", ""));
            if (Da != null) {
                MessageManager.getInstance().dispatchResponsedMessage(Da);
            }
        }
    }
}
