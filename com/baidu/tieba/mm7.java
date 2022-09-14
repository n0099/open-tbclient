package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes5.dex */
public class mm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public zl7 b;
    public LinkedHashMap<String, cm7> c;

    public mm7(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (dataRes == null) {
            return;
        }
        String str = dataRes.grade_intro_title;
        String str2 = dataRes.grade_intro_link;
        new lm7(dataRes);
        new nm7(dataRes.special_list);
        new em7(dataRes.cooperate_list);
        new im7(dataRes.theme_list);
        new am7(dataRes.banner_list);
        new qm7(dataRes.task_list);
        new pm7(dataRes.rank, dataRes.user);
        new gm7(dataRes.daily_list);
        zl7 zl7Var = new zl7();
        this.b = zl7Var;
        zl7Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    cm7 cm7Var = new cm7(vipBasicList);
                    if (cm7Var.c != 3 || cm7Var.a().size() >= 2) {
                        this.c.put(cm7Var.d, cm7Var);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        this.a = new ArrayList<>();
        for (String str3 : dataRes.card_order) {
            if (!StringUtils.isNull(str3)) {
                this.a.add(str3);
            }
        }
    }
}
