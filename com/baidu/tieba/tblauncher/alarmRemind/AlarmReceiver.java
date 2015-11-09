package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        RemindRecommendMessage lU;
        if (i.iN()) {
            String loadString = TbadkSettings.getInst().loadString(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "remind_recommend_info", "");
            if (TextUtils.isEmpty(loadString)) {
                lU = a.azP();
            } else {
                lU = a.lU(loadString);
            }
            if (lU != null) {
                MessageManager.getInstance().dispatchResponsedMessage(lU);
            }
        }
    }
}
