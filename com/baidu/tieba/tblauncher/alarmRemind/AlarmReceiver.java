package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.pea;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AlarmReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AlarmReceiver() {
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
        if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || !BdNetTypeUtil.isNetWorkAvailable() || !pea.e() || pea.f(SharedPrefHelper.getInstance().getLong("tieba_last_active_time", 0L))) {
            return;
        }
        RemindRecommendMessage a = pea.a(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", ""));
        if (a != null) {
            MessageManager.getInstance().dispatchResponsedMessage(a);
        }
    }
}
