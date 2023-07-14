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
/* loaded from: classes7.dex */
public class r69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public e69 b;
    public LinkedHashMap<String, h69> c;

    public r69(DataRes dataRes) {
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
        new q69(dataRes);
        new s69(dataRes.special_list);
        new j69(dataRes.cooperate_list);
        new n69(dataRes.theme_list);
        new f69(dataRes.banner_list);
        new v69(dataRes.task_list);
        new u69(dataRes.rank, dataRes.user);
        new l69(dataRes.daily_list);
        e69 e69Var = new e69();
        this.b = e69Var;
        e69Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    h69 h69Var = new h69(vipBasicList);
                    if (h69Var.c != 3 || h69Var.a().size() >= 2) {
                        this.c.put(h69Var.d, h69Var);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 != null && list3.size() > 0) {
            this.a = new ArrayList<>();
            for (String str3 : dataRes.card_order) {
                if (!StringUtils.isNull(str3)) {
                    this.a.add(str3);
                }
            }
        }
    }
}
