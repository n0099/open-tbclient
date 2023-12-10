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
public class rm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public em9 b;
    public LinkedHashMap<String, hm9> c;

    public rm9(DataRes dataRes) {
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
        new qm9(dataRes);
        new sm9(dataRes.special_list);
        new jm9(dataRes.cooperate_list);
        new nm9(dataRes.theme_list);
        new fm9(dataRes.banner_list);
        new vm9(dataRes.task_list);
        new um9(dataRes.rank, dataRes.user);
        new lm9(dataRes.daily_list);
        em9 em9Var = new em9();
        this.b = em9Var;
        em9Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    hm9 hm9Var = new hm9(vipBasicList);
                    if (hm9Var.c != 3 || hm9Var.a().size() >= 2) {
                        this.c.put(hm9Var.d, hm9Var);
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
