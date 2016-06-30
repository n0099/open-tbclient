package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (i.fr() && a.beg() && !a.cC(com.baidu.tbadk.core.sharedPref.b.sO().getLong("tieba_last_active_time", 0L))) {
            RemindRecommendMessage pR = a.pR(TbadkSettings.getInst().loadString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", ""));
            if (pR != null) {
                MessageManager.getInstance().dispatchResponsedMessage(pR);
            }
        }
    }
}
