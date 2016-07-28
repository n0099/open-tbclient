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
        if (i.fq() && a.bhy() && !a.cB(com.baidu.tbadk.core.sharedPref.b.sN().getLong("tieba_last_active_time", 0L))) {
            RemindRecommendMessage qB = a.qB(TbadkSettings.getInst().loadString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", ""));
            if (qB != null) {
                MessageManager.getInstance().dispatchResponsedMessage(qB);
            }
        }
    }
}
