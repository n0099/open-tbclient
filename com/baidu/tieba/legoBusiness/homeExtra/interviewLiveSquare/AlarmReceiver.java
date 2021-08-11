package com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AlarmReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TID = "tid";
    public static final String TITLE = "title";
    public transient /* synthetic */ FieldHolder $fh;

    public AlarmReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || (stringExtra = intent.getStringExtra("uid")) == null || !stringExtra.equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
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
