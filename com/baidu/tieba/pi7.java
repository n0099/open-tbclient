package com.baidu.tieba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.legoBusiness.homeExtra.interviewLiveSquare.AlarmReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class pi7 extends qn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qn4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/registerInterviewNotice" : (String) invokeV.objValue;
    }

    public pi7() {
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

    @Override // com.baidu.tieba.qn4, com.baidu.tieba.tn4
    public vn4 b(Object obj, HashMap hashMap, String str) {
        InterceptResult invokeLLL;
        Map.Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, hashMap, str)) == null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            vn4 vn4Var = new vn4();
            if (obj instanceof ih7) {
                ih7 ih7Var = (ih7) obj;
                boolean c = ih7Var.c();
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent(context, AlarmReceiver.class);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.putExtra("uid", TbadkCoreApplication.getCurrentAccount());
                intent.setData(Uri.parse(currentAccount));
                long j = 0;
                Iterator it = hashMap.entrySet().iterator();
                int i = 0;
                while (it.hasNext() && (entry = (Map.Entry) it.next()) != null) {
                    intent.putExtra((String) entry.getKey(), (String) entry.getValue());
                    if ("task_id".equals(entry.getKey())) {
                        i = Integer.parseInt((String) entry.getValue());
                    } else if ("s_time".equals(entry.getKey())) {
                        j = Long.parseLong((String) entry.getValue()) * 1000;
                    }
                }
                StatisticItem statisticItem = new StatisticItem(ih7Var.i());
                statisticItem.param("obj_id", "");
                if (c) {
                    statisticItem.param("obj_type", "2");
                    BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f0963)).i();
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    if (broadcast != null) {
                        alarmManager.cancel(broadcast);
                        broadcast.cancel();
                    }
                    vn4Var.a = false;
                } else {
                    statisticItem.param("obj_type", "1");
                    BdToast.b(context, context.getString(R.string.obfuscated_res_0x7f0f096e)).i();
                    alarmManager.set(0, j, PendingIntent.getBroadcast(context, i, intent, 134217728));
                    vn4Var.a = true;
                }
                TiebaStatic.log(statisticItem);
                ih7Var.l(vn4Var.a);
            }
            return vn4Var;
        }
        return (vn4) invokeLLL.objValue;
    }
}
