package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
/* loaded from: classes9.dex */
public class m {
    public com.baidu.tieba.memberCenter.index.adapter.a lnA;
    public g lnB;
    public LinkedHashMap<String, c> lnC;
    private ArrayList<String> lnp;
    private String lnq;
    private String lnr;
    public l lns;
    public n lnt;
    public e lnu;
    public i lnv;
    public a lnw;
    public q lnx;
    public p lny;
    public k lnz;

    public m(DataRes dataRes) {
        if (dataRes != null) {
            this.lnq = dataRes.grade_intro_title;
            this.lnr = dataRes.grade_intro_link;
            this.lns = new l(dataRes);
            this.lnt = new n(dataRes.special_list);
            this.lnu = new e(dataRes.cooperate_list);
            this.lnv = new i(dataRes.theme_list);
            this.lnw = new a(dataRes.banner_list);
            this.lnx = new q(dataRes.task_list);
            this.lny = new p(dataRes.rank, dataRes.user);
            this.lnB = new g(dataRes.daily_list);
            this.lnA = new com.baidu.tieba.memberCenter.index.adapter.a();
            this.lnA.a(dataRes);
            this.lnz = new k();
            if (dataRes.basic_list != null && dataRes.basic_list.size() > 0) {
                this.lnC = new LinkedHashMap<>();
                for (VipBasicList vipBasicList : dataRes.basic_list) {
                    if (vipBasicList.item != null && vipBasicList.item.size() > 0) {
                        c cVar = new c(vipBasicList);
                        if (cVar.type != 3 || cVar.dfj().size() >= 2) {
                            this.lnC.put(cVar.cardId, cVar);
                        }
                    }
                }
            }
            if (dataRes.card_order != null && dataRes.card_order.size() > 0) {
                this.lnp = new ArrayList<>();
                for (String str : dataRes.card_order) {
                    if (!StringUtils.isNull(str)) {
                        this.lnp.add(str);
                    }
                }
            }
        }
    }
}
