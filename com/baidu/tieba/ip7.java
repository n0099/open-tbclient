package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes4.dex */
public class ip7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ip7(VipSpecialItem vipSpecialItem) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialItem};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = vipSpecialItem.title;
        String str2 = vipSpecialItem.desc;
        String str3 = vipSpecialItem.img_url;
        String str4 = vipSpecialItem.link;
        String str5 = vipSpecialItem.update_time;
        vipSpecialItem.id.intValue();
        vipSpecialItem.type.intValue();
        vipSpecialItem.task_id.intValue();
        vipSpecialItem.is_finish.intValue();
    }
}
