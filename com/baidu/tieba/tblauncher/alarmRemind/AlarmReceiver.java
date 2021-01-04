package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (j.isNetWorkAvailable() && a.dRX() && !a.isTaday(com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.TIEBA_LAST_ACTIVE_TIME, 0L))) {
            RemindRecommendMessage Ua = a.Ua(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_RECOMMEND_INFO, ""));
            if (Ua != null) {
                MessageManager.getInstance().dispatchResponsedMessage(Ua);
            }
        }
    }
}
