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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru4;
import com.repackage.sn7;
/* loaded from: classes3.dex */
public class CollectUpdateReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_NAME = "com.baidu.tieba.broadcast.collectupdate";
    public transient /* synthetic */ FieldHolder $fh;

    public CollectUpdateReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && ACTION_NAME.equals(intent.getAction())) {
            sn7.b().g();
            if (ru4.k().h("collect_update_flag_key" + TbadkCoreApplication.getCurrentAccount(), false)) {
                try {
                    Intent intent2 = new Intent(context, DealIntentService.class);
                    intent2.putExtra(DealIntentService.KEY_CLASS, 33);
                    intent2.putExtra("is_notify", true);
                    intent2.setFlags(603979776);
                    PendingIntent service = PendingIntent.getService(context, 0, intent2, 134217728);
                    String string = context.getString(R.string.obfuscated_res_0x7f0f03fe);
                    NotificationHelper.showNotification(context, 28, context.getString(R.string.obfuscated_res_0x7f0f029e), string, string, service, false);
                } catch (Throwable th) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e(th.getMessage());
                    }
                }
            }
        }
    }
}
