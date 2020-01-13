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
/* loaded from: classes7.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (j.isNetWorkAvailable() && a.cLM() && !a.isTaday(com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.TIEBA_LAST_ACTIVE_TIME, 0L))) {
            RemindRecommendMessage Jn = a.Jn(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + SharedPrefConfig.REMIND_RECOMMEND_INFO, ""));
            if (Jn != null) {
                MessageManager.getInstance().dispatchResponsedMessage(Jn);
            }
        }
    }
}
