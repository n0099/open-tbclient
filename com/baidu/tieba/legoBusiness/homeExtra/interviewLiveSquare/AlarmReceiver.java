package com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class AlarmReceiver extends BroadcastReceiver {
    private static final String TID = "tid";
    private static final String TITLE = "title";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("uid")) != null && stringExtra.equals(TbadkCoreApplication.getCurrentAccount())) {
            String stringExtra2 = intent.getStringExtra("task_id");
            String string = TbadkCoreApplication.getInst().getResources().getString(R.string.interview_push_ticker_message, intent.getStringExtra("title"));
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.lego_interview_live);
            Intent intent2 = new Intent(TbadkCoreApplication.getInst().getContext(), NotificationReceiver.class);
            int parseInt = Integer.parseInt(stringExtra2);
            intent2.putExtra("thread_id", intent.getStringExtra("tid"));
            intent2.putExtra("task_id", stringExtra2);
            NotificationHelper.showNotification(TbadkCoreApplication.getInst(), parseInt, string2, string, string, PendingIntent.getBroadcast(TbadkCoreApplication.getInst(), parseInt, intent2, 134217728), false);
        }
    }
}
