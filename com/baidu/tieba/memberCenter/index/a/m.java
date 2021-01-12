package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
/* loaded from: classes8.dex */
public class m {
    private ArrayList<String> leY;
    private String leZ;
    private String lfa;
    public l lfb;
    public n lfc;
    public e lfd;
    public i lfe;
    public a lff;
    public q lfg;
    public p lfh;
    public k lfi;
    public com.baidu.tieba.memberCenter.index.adapter.a lfj;
    public g lfk;
    public LinkedHashMap<String, c> lfl;

    public m(DataRes dataRes) {
        if (dataRes != null) {
            this.leZ = dataRes.grade_intro_title;
            this.lfa = dataRes.grade_intro_link;
            this.lfb = new l(dataRes);
            this.lfc = new n(dataRes.special_list);
            this.lfd = new e(dataRes.cooperate_list);
            this.lfe = new i(dataRes.theme_list);
            this.lff = new a(dataRes.banner_list);
            this.lfg = new q(dataRes.task_list);
            this.lfh = new p(dataRes.rank, dataRes.user);
            this.lfk = new g(dataRes.daily_list);
            this.lfj = new com.baidu.tieba.memberCenter.index.adapter.a();
            this.lfj.a(dataRes);
            this.lfi = new k();
            if (dataRes.basic_list != null && dataRes.basic_list.size() > 0) {
                this.lfl = new LinkedHashMap<>();
                for (VipBasicList vipBasicList : dataRes.basic_list) {
                    if (vipBasicList.item != null && vipBasicList.item.size() > 0) {
                        c cVar = new c(vipBasicList);
                        if (cVar.type != 3 || cVar.ddc().size() >= 2) {
                            this.lfl.put(cVar.cardId, cVar);
                        }
                    }
                }
            }
            if (dataRes.card_order != null && dataRes.card_order.size() > 0) {
                this.leY = new ArrayList<>();
                for (String str : dataRes.card_order) {
                    if (!StringUtils.isNull(str)) {
                        this.leY.add(str);
                    }
                }
            }
        }
    }
}
