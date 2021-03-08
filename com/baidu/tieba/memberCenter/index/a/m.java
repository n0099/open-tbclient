package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
/* loaded from: classes8.dex */
public class m {
    public e lpA;
    public i lpB;
    public a lpC;
    public q lpD;
    public p lpE;
    public k lpF;
    public com.baidu.tieba.memberCenter.index.adapter.a lpG;
    public g lpH;
    public LinkedHashMap<String, c> lpI;
    private ArrayList<String> lpv;
    private String lpw;
    private String lpx;
    public l lpy;
    public n lpz;

    public m(DataRes dataRes) {
        if (dataRes != null) {
            this.lpw = dataRes.grade_intro_title;
            this.lpx = dataRes.grade_intro_link;
            this.lpy = new l(dataRes);
            this.lpz = new n(dataRes.special_list);
            this.lpA = new e(dataRes.cooperate_list);
            this.lpB = new i(dataRes.theme_list);
            this.lpC = new a(dataRes.banner_list);
            this.lpD = new q(dataRes.task_list);
            this.lpE = new p(dataRes.rank, dataRes.user);
            this.lpH = new g(dataRes.daily_list);
            this.lpG = new com.baidu.tieba.memberCenter.index.adapter.a();
            this.lpG.a(dataRes);
            this.lpF = new k();
            if (dataRes.basic_list != null && dataRes.basic_list.size() > 0) {
                this.lpI = new LinkedHashMap<>();
                for (VipBasicList vipBasicList : dataRes.basic_list) {
                    if (vipBasicList.item != null && vipBasicList.item.size() > 0) {
                        c cVar = new c(vipBasicList);
                        if (cVar.type != 3 || cVar.dfs().size() >= 2) {
                            this.lpI.put(cVar.cardId, cVar);
                        }
                    }
                }
            }
            if (dataRes.card_order != null && dataRes.card_order.size() > 0) {
                this.lpv = new ArrayList<>();
                for (String str : dataRes.card_order) {
                    if (!StringUtils.isNull(str)) {
                        this.lpv.add(str);
                    }
                }
            }
        }
    }
}
