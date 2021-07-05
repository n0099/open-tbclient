package com.baidu.tieba.service;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.s.d.b;
/* loaded from: classes5.dex */
public class SignAlertReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SignAlertReceiver() {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals(TbConfig.getBroadcastActionSignAlert())) {
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
                b.g0().j(b.g0().C(12), 12);
                NotificationHelper.showNotification(context, 12, string2, string, string, service, false);
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_PUSH_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
