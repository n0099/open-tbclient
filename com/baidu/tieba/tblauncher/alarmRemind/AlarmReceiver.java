package com.baidu.tieba.tblauncher.alarmRemind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.a.e.f.p.j;
import b.a.q0.s.e0.b;
import b.a.r0.p3.h.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RemindRecommendMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AlarmReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && j.z() && a.e() && !a.f(b.j().l("tieba_last_active_time", 0L))) {
            RemindRecommendMessage a2 = a.a(TbadkSettings.getInst().loadString(TbadkCoreApplication.getCurrentAccount() + "remind_recommend_info", ""));
            if (a2 != null) {
                MessageManager.getInstance().dispatchResponsedMessage(a2);
            }
        }
    }
}
