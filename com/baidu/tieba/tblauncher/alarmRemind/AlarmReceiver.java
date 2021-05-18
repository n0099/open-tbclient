package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import d.a.c.e.p.j;
import d.a.j0.r.d0.b;
import d.a.k0.g3.f.a;
/* loaded from: classes5.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (j.z() && a.e() && !a.f(b.j().l("tieba_last_active_time", 0L))) {
            RemindRecommendMessage a2 = a.a(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", ""));
            if (a2 != null) {
                MessageManager.getInstance().dispatchResponsedMessage(a2);
            }
        }
    }
}
