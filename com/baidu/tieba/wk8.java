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
/* loaded from: classes6.dex */
public class wk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public jk8 b;
    public LinkedHashMap<String, mk8> c;

    public wk8(DataRes dataRes) {
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
        new vk8(dataRes);
        new xk8(dataRes.special_list);
        new ok8(dataRes.cooperate_list);
        new sk8(dataRes.theme_list);
        new kk8(dataRes.banner_list);
        new al8(dataRes.task_list);
        new zk8(dataRes.rank, dataRes.user);
        new qk8(dataRes.daily_list);
        jk8 jk8Var = new jk8();
        this.b = jk8Var;
        jk8Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    mk8 mk8Var = new mk8(vipBasicList);
                    if (mk8Var.c != 3 || mk8Var.a().size() >= 2) {
                        this.c.put(mk8Var.d, mk8Var);
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
