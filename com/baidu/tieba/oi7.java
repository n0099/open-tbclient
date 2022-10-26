package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class oi7 extends qn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qn4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "interview/checkInterviewNoticeStatus" : (String) invokeV.objValue;
    }

    public oi7() {
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
            Context baseContext = TbadkCoreApplication.getInst().getBaseContext();
            vn4 vn4Var = new vn4();
            if (obj instanceof ih7) {
                ih7 ih7Var = (ih7) obj;
                Intent intent = new Intent(baseContext, AlarmReceiver.class);
                Iterator it = hashMap.entrySet().iterator();
                boolean z = false;
                int i = 0;
                while (it.hasNext() && (entry = (Map.Entry) it.next()) != null) {
                    intent.putExtra((String) entry.getKey(), (String) entry.getValue());
                    if ("task_id".equals(entry.getKey())) {
                        i = Integer.parseInt((String) entry.getValue());
                    }
                }
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = "";
                }
                intent.setData(Uri.parse(currentAccount));
                if (PendingIntent.getBroadcast(baseContext, i, intent, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH) != null) {
                    z = true;
                }
                vn4Var.a = z;
                ih7Var.m(true);
                ih7Var.l(vn4Var.a);
            }
            return vn4Var;
        }
        return (vn4) invokeLLL.objValue;
    }
}
