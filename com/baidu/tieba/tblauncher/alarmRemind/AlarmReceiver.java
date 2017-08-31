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
        if (i.hi() && a.buk() && !a.cQ(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("tieba_last_active_time", 0L))) {
            RemindRecommendMessage sx = a.sx(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", ""));
            if (sx != null) {
                MessageManager.getInstance().dispatchResponsedMessage(sx);
            }
        }
    }
}
