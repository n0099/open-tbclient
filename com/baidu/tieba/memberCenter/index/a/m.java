package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
/* loaded from: classes9.dex */
public class m {
    private ArrayList<String> ljD;
    private String ljE;
    private String ljF;
    public l ljG;
    public n ljH;
    public e ljI;
    public i ljJ;
    public a ljK;
    public q ljL;
    public p ljM;
    public k ljN;
    public com.baidu.tieba.memberCenter.index.adapter.a ljO;
    public g ljP;
    public LinkedHashMap<String, c> ljQ;

    public m(DataRes dataRes) {
        if (dataRes != null) {
            this.ljE = dataRes.grade_intro_title;
            this.ljF = dataRes.grade_intro_link;
            this.ljG = new l(dataRes);
            this.ljH = new n(dataRes.special_list);
            this.ljI = new e(dataRes.cooperate_list);
            this.ljJ = new i(dataRes.theme_list);
            this.ljK = new a(dataRes.banner_list);
            this.ljL = new q(dataRes.task_list);
            this.ljM = new p(dataRes.rank, dataRes.user);
            this.ljP = new g(dataRes.daily_list);
            this.ljO = new com.baidu.tieba.memberCenter.index.adapter.a();
            this.ljO.a(dataRes);
            this.ljN = new k();
            if (dataRes.basic_list != null && dataRes.basic_list.size() > 0) {
                this.ljQ = new LinkedHashMap<>();
                for (VipBasicList vipBasicList : dataRes.basic_list) {
                    if (vipBasicList.item != null && vipBasicList.item.size() > 0) {
                        c cVar = new c(vipBasicList);
                        if (cVar.type != 3 || cVar.dgU().size() >= 2) {
                            this.ljQ.put(cVar.cardId, cVar);
                        }
                    }
                }
            }
            if (dataRes.card_order != null && dataRes.card_order.size() > 0) {
                this.ljD = new ArrayList<>();
                for (String str : dataRes.card_order) {
                    if (!StringUtils.isNull(str)) {
                        this.ljD.add(str);
                    }
                }
            }
        }
    }
}
