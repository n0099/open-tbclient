package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
/* loaded from: classes9.dex */
public class m {
    private ArrayList<String> lna;
    private String lnb;
    private String lnc;
    public l lnd;
    public n lne;
    public e lnf;
    public i lnh;
    public a lni;
    public q lnj;
    public p lnk;
    public k lnl;
    public com.baidu.tieba.memberCenter.index.adapter.a lnm;
    public g lnn;
    public LinkedHashMap<String, c> lno;

    public m(DataRes dataRes) {
        if (dataRes != null) {
            this.lnb = dataRes.grade_intro_title;
            this.lnc = dataRes.grade_intro_link;
            this.lnd = new l(dataRes);
            this.lne = new n(dataRes.special_list);
            this.lnf = new e(dataRes.cooperate_list);
            this.lnh = new i(dataRes.theme_list);
            this.lni = new a(dataRes.banner_list);
            this.lnj = new q(dataRes.task_list);
            this.lnk = new p(dataRes.rank, dataRes.user);
            this.lnn = new g(dataRes.daily_list);
            this.lnm = new com.baidu.tieba.memberCenter.index.adapter.a();
            this.lnm.a(dataRes);
            this.lnl = new k();
            if (dataRes.basic_list != null && dataRes.basic_list.size() > 0) {
                this.lno = new LinkedHashMap<>();
                for (VipBasicList vipBasicList : dataRes.basic_list) {
                    if (vipBasicList.item != null && vipBasicList.item.size() > 0) {
                        c cVar = new c(vipBasicList);
                        if (cVar.type != 3 || cVar.dfc().size() >= 2) {
                            this.lno.put(cVar.cardId, cVar);
                        }
                    }
                }
            }
            if (dataRes.card_order != null && dataRes.card_order.size() > 0) {
                this.lna = new ArrayList<>();
                for (String str : dataRes.card_order) {
                    if (!StringUtils.isNull(str)) {
                        this.lna.add(str);
                    }
                }
            }
        }
    }
}
