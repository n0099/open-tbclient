package com.baidu.tieba.myCollection;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CollectUpdateReceiver extends BroadcastReceiver {
    public static final String ACTION_NAME = "com.baidu.tieba.broadcast.collectupdate";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (ACTION_NAME.equals(intent.getAction())) {
            b.djg().djk();
            if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), false)) {
                try {
                    Intent intent2 = new Intent(context, DealIntentService.class);
                    intent2.putExtra(DealIntentService.KEY_CLASS, 33);
                    intent2.putExtra("is_notify", true);
                    intent2.setFlags(603979776);
                    PendingIntent service = PendingIntent.getService(context, 0, intent2, 134217728);
                    String string = context.getString(R.string.collect_update_notification_content);
                    NotificationHelper.showNotification(context, 28, context.getString(R.string.app_name), string, string, service, false);
                } catch (Throwable th) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                }
            }
        }
    }
}
