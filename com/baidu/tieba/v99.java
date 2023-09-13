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
/* loaded from: classes8.dex */
public class v99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public i99 b;
    public LinkedHashMap<String, l99> c;

    public v99(DataRes dataRes) {
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
        new u99(dataRes);
        new w99(dataRes.special_list);
        new n99(dataRes.cooperate_list);
        new r99(dataRes.theme_list);
        new j99(dataRes.banner_list);
        new z99(dataRes.task_list);
        new y99(dataRes.rank, dataRes.user);
        new p99(dataRes.daily_list);
        i99 i99Var = new i99();
        this.b = i99Var;
        i99Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    l99 l99Var = new l99(vipBasicList);
                    if (l99Var.c != 3 || l99Var.a().size() >= 2) {
                        this.c.put(l99Var.d, l99Var);
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
