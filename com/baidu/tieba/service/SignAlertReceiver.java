package com.baidu.tieba.service;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.messageCenter.b;
import com.baidu.tbadk.coreExtra.messageCenter.d;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SignAlertReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TbConfig.getBroadcastActionSignAlert())) {
            try {
                Intent intent2 = new Intent(context, DealIntentService.class);
                intent2.putExtra(DealIntentService.KEY_CLASS, 9);
                intent2.putExtra("is_message_pv", true);
                intent2.putExtra("is_notify", true);
                intent2.putExtra(FrsActivityConfig.KEY_REFRESH, true);
                intent2.putExtra("close_dialog", true);
                intent2.putExtra("locate_type", 1);
                intent2.setFlags(603979776);
                PendingIntent service = PendingIntent.getService(context, 0, intent2, 134217728);
                String string = context.getString(R.string.sign_notification_content);
                String string2 = context.getString(R.string.app_name);
                b.bxB().s(b.bxB().qt(12), 12);
                NotificationHelper.showNotification(context, 12, string2, string, string, service, false);
                ar arVar = new ar("c13252");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(arVar);
            } catch (Throwable th) {
                try {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                } finally {
                    d.bye().updateSignAlarm();
                }
            }
        }
    }
}
